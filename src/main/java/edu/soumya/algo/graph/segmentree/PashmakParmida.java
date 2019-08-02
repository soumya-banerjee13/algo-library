package edu.soumya.algo.graph.segmentree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PashmakParmida {
	//0-based indexing, index 1 is the root
	static int[] segmentTree;
	
	/**
	 * Increment the value at the given position by 1
	 */ 
	static void singleIncrement(int position,int n){
		for(segmentTree[position+=n] ++;position>1;position/=2){
			segmentTree[position/2] = segmentTree[position] + segmentTree[position^1];
		}
	}
	
	static int rangeQuery(int left, int right,int n){
		int res = 0;
		for(left+=n, right+=n;left<right;left/=2,right/=2){
			if(left%2!=0) res += segmentTree[left++];
			if(right%2!=0) res += segmentTree[--right];
		}
		return res;
	}
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		HashMap<Integer,Integer> hmapLeft = new HashMap<>();
		HashMap<Integer,Integer> hmapRight = new HashMap<>();
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
			hmapLeft.put(arr[i],0);
			hmapRight.put(arr[i], 0);
		}
		int[] left = new int[n];
		int[] right = new int[n];
		for(int i=0;i<n;i++) {
			hmapLeft.put(arr[i],hmapLeft.get(arr[i])+1);
			left[i] = hmapLeft.get(arr[i]);
		}
		for(int i=n-1;i>=0;i--) {
			hmapRight.put(arr[i],hmapRight.get(arr[i])+1);
			right[i] = hmapRight.get(arr[i]);
		}
		segmentTree = new int[2*n];
		long result = 0L;
		for(int i=0;i<n;i++) {
			result+=rangeQuery(right[i],n,n);
			singleIncrement(left[i]-1,n);
		}
		System.out.println(result);
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
		
		public char nextChar() {
			String next = next();
			if(next.length()>1) {
				throw new RuntimeException("Input is not a single character");
			}
			return next.charAt(0);
		}
	}
}
