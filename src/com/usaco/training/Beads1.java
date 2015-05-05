package com.usaco.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Beads1 {
	public static void main(String[] args) throws IOException {

		// Scanner in = new Scanner(new File(""));
		// PrintWriter out = new PrintWriter(new File(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Input:");

		int length = Integer.parseInt(br.readLine());
		String necklace = br.readLine();

		Beads1 beads = new Beads1();

		int maxBeads = beads.solve(length, necklace.toCharArray());

		System.out.println(maxBeads);
	}

	public int solve(int length, char[] necklace) {
		int ret = 0;
		char leftEnd, rightEnd;
		int sum = 0;
		try {
			for (int i = 0; i < length; i++) {
				leftEnd = necklace[i];
				rightEnd = necklace[i + 1 == length ? 0 : i + 1];

				int leftEndIndex = i;
				int rightEndIndex = i + 1 == length ? 0 : i + 1;

				if (leftEnd != rightEnd) {
					sum = 0;
					int idx = leftEndIndex;
					if (leftEnd == 'w') {
						while (necklace[getIndex(idx, length)] == 'w') {
							idx--;
							sum++;
						}
						leftEnd = necklace[getIndex(idx, length)];
					}
					System.out.println("leftEnd: " + leftEnd);
					while (leftEnd == necklace[getIndex(idx, length)]
							|| necklace[getIndex(idx, length)] == 'w') {
						idx--;
						sum++;
						if (Math.abs(idx) > length) break;
					}
					idx = rightEndIndex;
					if (rightEnd == 'w') {
						while (necklace[getIndex(idx, length)] == 'w') {
							idx++;
							sum++;
						}
						rightEnd = necklace[getIndex(idx, length)];
					}
					System.out.println("rightEnd: " + rightEnd);
					while (rightEnd == necklace[getIndex(idx, length)]
							|| necklace[getIndex(idx, length)] == 'w') {
						idx++;
						sum++;
						if (Math.abs(idx) >= length) break;
					}

					if (sum >= length) {
						sum = length;
					}
				}

				ret = Math.max(ret, sum);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int getIndex(int index, int length) {
		if (index >= 0 && index < length) {
			return index;
		} else if (index < 0 && Math.abs(index) <= length) {
			return length - Math.abs(index);
		} else {
			return -1;
		}
	}
}

