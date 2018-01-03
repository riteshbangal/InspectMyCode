package com.java.learning.concurrency.atpapproach.second;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class MathCalculator {
	
	static MemCachedClient cachedClient;
	
	static CacheManager cacheManager;
	static Cache ehcache; 
	static {
		// initialize the SockIOPool that maintains the Memcached Server Connection Pool
		String[] servers = { "localhost:11111" };
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers(servers);
		pool.setFailover(true);
		pool.setInitConn(10);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setAliveCheck(true);
		pool.initialize();
		cachedClient = new MemCachedClient("Test1");
		System.out.println("MemCachedClient: cachedClient created...");
		
		cacheManager = CacheManager.getInstance();
		cacheManager.addCache("MathCalculator");
		ehcache = cacheManager.getCache("MathCalculator");
	}

	public static long calculateNumberOfDivisible(long first, long last, long divisor) {
		long amount = 0;
		for (long i = first; i <= last; i++) {
			if (i % divisor == 0) {
				amount++;
			}
		}
		return amount;
	}
	
	public static Output calculate(Input pInput) {

		System.out.println("Input: " + pInput);
		if (ehcache.isKeyInCache(pInput.toString())) {
			System.out.println("Reading from EhCache..");
			Element element = ehcache.get(pInput.toString());
			return (Output) element.getObjectValue();
		} else if (cachedClient.get(pInput.toString()) != null) {
			System.out.println("Reading from MemCachedClient..");
			return (Output) cachedClient.get(pInput.toString());
		}
		
		long result = 0;
		sleep();
		
		switch (pInput.getOperation()) {
		case "+":
			result = pInput.getNumOne() + pInput.getNumTwo();
			break;
		case "-":
			result = pInput.getNumOne() - pInput.getNumTwo();
			break;
		case "*":
			result = pInput.getNumOne() * pInput.getNumTwo();
			break;
		case "/":
			result = pInput.getNumOne() / pInput.getNumTwo();
			break;
		default:
			break;
		}
		
		Output output = new Output(pInput, result);
		cachedClient.set(pInput.toString(), output);
		ehcache.put(new Element(pInput.toString(), output));
		return output;
	}

	private static void sleep() {
		//calculateNumberOfDivisible(0, 300000003, 3);
		try {
			Thread.sleep(1 * 1000);
			//Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
