package edu.soumya.algo.interactive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int left = 1;
		int right = 1000000;
		while(left!=right) {
			int mid = (right+left+1)/2;
			System.out.println(mid);
			System.out.flush();
			
			String response = scan.next();
			if(response.equals(">=")) {
				left = mid;
			} else {
				right = mid-1;
			}
		}
		System.out.println("! "+left);
		System.out.flush();
		scan.close();
	}
}
