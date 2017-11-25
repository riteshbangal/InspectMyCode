package com.java.learning.memory;

import java.util.ArrayList;
import java.util.List;

public class ObjectMemoryTest {
	
	private static final long MEGABYTE = 1024L * 1024L;

	public static void main(String[] args) {
		
		// Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
		
		Vehicle vehicle = null;
		long memory0 = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory2 is bytes: " + memory0);
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < getAllVehicles().size(); i++) {
			int craters = getAllVehicles().get(i).getTimeToCrossCrater();
			if (craters < min) {
				min = craters;
				Vehicle tempvehicle = vehicle;
				vehicle = getAllVehicles().get(i);
				if (vehicle.equals(tempvehicle)) {
					System.out.println("equals");
				}
				long memory1 = runtime.totalMemory() - runtime.freeMemory();
		        System.out.println("Used memory1 is bytes: " + memory1);
			}
		}

		new Vehicle("Bikeo", new Velocity(10, "megamiles/min"), 57);
		long memory2 = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory2 is bytes: " + memory2);
        
        
        System.out.println("*****************************************************");
        String str = new String("RCB");
		String lStr = str;
		if (lStr.equals(str)) {
			System.out.println("string equals");
		}
        
        System.out.println("*****************************************************");
        StringBuilder sb0 = new StringBuilder("RCB");
        System.out.println("Used sb0 is bytes: " + (runtime.totalMemory() - runtime.freeMemory()));
        StringBuilder sb1 = new StringBuilder("TGB");
        System.out.println("Used sb1 is bytes: " + (runtime.totalMemory() - runtime.freeMemory()));
        StringBuilder lsb = sb0;
        System.out.println("Used lsb is bytes: " + (runtime.totalMemory() - runtime.freeMemory()));
		if (lsb.equals(sb0)) {
			System.out.println("StringBuilder sb0 equals");
		}
        lsb = sb1;
		if (lsb.equals(sb0)) {
			System.out.println("StringBuilder sb1 equals");
		}
	}
	
	public static List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle("Bike", new Velocity(10, "megamiles/hour"), 5));
		vehicles.add(new Vehicle("Tuktuk", new Velocity(12, "megamiles/hour"), 4));
		vehicles.add(new Vehicle("Car", new Velocity(20, "megamiles/hour"), 2));
		vehicles.add(new Vehicle("Car", new Velocity(20, "megamiles/hour"), 2));
		return vehicles;
	}
	
	public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
}
