package com.ksk.ds.dp;

import java.time.Duration;
import java.time.Instant;

public class StairsProblem {

	public static void main(String[] args) {

		int steps = 40;
		Instant start = Instant.now();
		long possibleWaysWith1or2 = noOfPossibleWaysWith2Steps(steps);
		Instant end = Instant.now();
		System.out.println("Total time is = "+Duration.between(start, end).toMillis());
		System.out.println("Result = "+possibleWaysWith1or2);
		
		Instant rStart = Instant.now();
		long possibleWaysWith1or2WithRecurstion = noOfPossibleWays(steps);
		Instant rEnd = Instant.now();
		System.out.println("Total time with Recursion = "+Duration.between(rStart, rEnd).toMillis());
		System.out.println("Result with Recurstion = "+possibleWaysWith1or2WithRecurstion);
		
		steps = 4;
		Instant startTime = Instant.now();
		long possibleWaysWith123 = noOfPossibleWaysWith123Steps(steps);
		Instant endTime = Instant.now();
		System.out.println("Total time for 1 or 2 or 3 = "+Duration.between(startTime, endTime).toMillis());
		System.out.println("Result with 1 or 2 or 3 = "+possibleWaysWith123);		
		
	}
	
	/*
	 * No of possible ways with 1 or 2 steps
	 */
	private static long noOfPossibleWaysWith2Steps(int n) {
		long[] resultArray = new long[n+1];
		resultArray[0] = 1;
		resultArray[1] = 1;
		resultArray[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			resultArray[i] = resultArray[i-1]+resultArray[i-2];
		}
		return resultArray[n];
	}
	
	/*
	 * recursive approach 
	 * this approach is not the good because it tries to calculate multiple times for the same step. It decreases
	 * the performance.
	 */
	private static long noOfPossibleWays(int n) {
		if(n == 0)
			return 1;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		return noOfPossibleWays(n-1) + noOfPossibleWays(n-2);
	}
	
	/*
	 * No of possible ways with 1 or 2 or 3 steps
	 * 
	 */
	private static long noOfPossibleWaysWith123Steps(int n) {
		long[] resultArray = new long[n+1];
		resultArray[0] = 1;
		resultArray[1] = 1;
		resultArray[2] = 2;
		for(int i = 3; i <= n; i++)
			resultArray[i] = resultArray[i-1]+resultArray[i-2]+resultArray[i-3];
		return resultArray[n];
	}

}
