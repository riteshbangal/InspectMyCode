/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.singlefilesolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * DESCRIPTION - Solution for the following problem.
 * 
 *  Search all possible combination of a subset arrays from a given array, 
 *  sum of which (numerator) will be divisible by a given number.
 *  Input - Array, denominator number and subsetLength.
 *  output - All possible array.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <08-December-2017>
 */
public class FindPossibleSubsets {

	public static void main(String[] args) {
		
		int[] inputArray = {12, 3, 5, 8};
		int denominator = 4;
		int subsetLength = 3;
		
		List<List<Integer>> possibleSubsets = new FindPossibleSubsets().getPossibleSubsets(inputArray);
		List<List<Integer>> outputs = possibleSubsets.stream()
				.filter(subset -> subset.size() == subsetLength)
				.filter(subset -> sum(subset) % denominator == 0)
				.collect(Collectors.toList());
		
		System.out.println(outputs);
	}

	private List<List<Integer>> getPossibleSubsets(int inputArray[]) {
		
		int n = inputArray.length;
		List<List<Integer>> possibleSubsets = new ArrayList<>();
		
		// Run a loop for printing all 2^n subsets one by one
		for (int i = 0; i < (1 << n); i++) {
			List<Integer> subset = new ArrayList<>();

			// Print current subset
			for (int j = 0; j < n; j++) {

				/*
				 * (1<<j) is a number with jth bit 1 so when we 'and' them with the
				 * subset number we get which numbers are present in the subset and which are not
				 */
				if ((i & (1 << j)) > 0) {
					subset.add(inputArray[j]);
				}
			}	

			possibleSubsets.add(subset);
		}
		return possibleSubsets;
	}
	
	private static int sum(List<Integer> subset) {
		AtomicInteger sum = new AtomicInteger(0);
		subset.stream()
			.forEach(num -> sum.getAndAdd(num));
		return sum.get();
	}
	
	@SuppressWarnings("unused")
	private static int combination(int n, int k) {
		return permutation(n) / (permutation(k) * permutation(n - k));
	}

	private static int permutation(int i) {
		if (i == 1) {
			return 1;
		}
		return i * permutation(i - 1);
	}
}
