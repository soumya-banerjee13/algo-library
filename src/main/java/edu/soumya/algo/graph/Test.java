package edu.soumya.algo.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] valArray = new String[75];
		for(int i=0;i<75;i++){
			valArray[i]=scanner.nextLine();
		}
		Arrays.sort(valArray);
		for(int i=0;i<75;i++){
			System.out.println(valArray[i]);
		}
		scanner.close();
	}
}
