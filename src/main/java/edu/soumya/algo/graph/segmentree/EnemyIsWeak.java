package edu.soumya.algo.graph.segmentree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EnemyIsWeak {
	//0-based indexing, index 1 is the root
	static int[] segmentTree;
	
	static int singleQuery(int position,int n){
		int res = 0;
		for(position+=n;position>1;position/=2){
			res += segmentTree[position];
		}
		return res;
	}
	
	static void rangeIncrement(int left, int right,int n){
		for(left+=n, right+=n;left<right;left/=2,right/=2){
			if(left%2!=0) segmentTree[left++]++;
			if(right%2!=0) segmentTree[--right]++;
		}
	}
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int[] sortArr = new int[n];
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
			sortArr[i] = arr[i];
		}
		Arrays.sort(sortArr);
		for(int i=0;i<n;i++) {
			hm.put(sortArr[i], i);
		}
		int[] mappedArr = new int[n];
		for(int i=0;i<n;i++) {
			mappedArr[i] = hm.get(arr[i]);
		}
		segmentTree = new int[2*n];
		int[] greater = new int[n];
		int[] lesser = new int[n];
		for(int i=0;i<n;i++) {
			greater[i] = singleQuery(mappedArr[i], n);
			lesser[i] = (mappedArr[i]-1)-(i-1-greater[i]);
			if(mappedArr[i]>0) rangeIncrement(0,mappedArr[i], n);
		}
		long result = 0L;
		for(int i=0;i<n;i++) {
			result+=(long)greater[i]*(long)lesser[i];
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
		
	}

}
