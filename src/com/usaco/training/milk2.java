package com.usaco.training;

/*
 ID: sandeep30
 LANG: JAVA
 TASK: milk2
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class milk2 {
	public static void main(String[] args) throws IOException {
//		Scanner in = new Scanner(System.in);
		
		Scanner in = new Scanner(new File("milk2.in"));
		PrintWriter out = new PrintWriter(new File("milk2.out"));
		
		int longestContinuousTime = 0;
		int longestIdleTime = 0;

		int formers = in.nextInt();

		Interval[] intervals = new Interval[formers];
		for (int i = 0; i < formers; i++) {
			intervals[i] = new Interval(in.nextInt(), in.nextInt());
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval first, Interval second) {
				return first.getLow() - second.getLow();
			}
		});

		int low = intervals[0].getLow();
		int high = intervals[0].getHigh();
		longestContinuousTime = high - low;
		longestIdleTime = 0;

		for (int i = 1; i < intervals.length; i++) {
			Interval temp = intervals[i];
			if (temp.getLow() <= high) {
				high = Math.max(temp.getHigh(), high);
			} else {
				longestContinuousTime = Math.max(longestContinuousTime, high - low);
				longestIdleTime = Math.max(longestIdleTime, temp.getLow() - high);
				low = temp.getLow();
				high = temp.getHigh();
			}
		}
		
//		System.out.println(longestContinuousTime + " " + longestIdleTime);
		out.println(longestContinuousTime + " " + longestIdleTime);
		out.close();
		in.close();
	}

	public void solve() {

	}

	private static class Interval {
		private int low;
		private int high;

		public Interval(int l, int h) {
			low = l;
			high = h;
		}

		public int getLow() {
			return low;
		}

		public int getHigh() {
			return high;
		}
	}
}
