package com.usaco.training;

/*
ID: sandeep30
LANG: JAVA
TASK: namenum
*/

import java.util.Scanner;

public class namenum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = "223";//in.next();
		
		namenum taggedName = new namenum();
		String ret = "";
		taggedName.solve(num, ret);
		
		in.close();
	}
	
	public String solve(String num, String ret) {
		if (num.length() > 0) {
			int digit = Integer.parseInt(num.substring(0, 1));
			
			if (digit == 2) {
				ret = "A" + solve(num.substring(1, num.length()), ret);
				System.out.println(ret);
			} else if (digit == 3) {
				ret = "D" + solve(num.substring(1, num.length()), ret);
				System.out.println(ret);
			}
		}
		return ret;
	}
}
