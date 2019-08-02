package edu.soumya.algo.graph.segmentree;

import java.io.IOException;
import java.util.Scanner;

public class XeniaBitOperations {
	//0-based indexing, index 1 is the root
	static int[] segmentTree;
	/** 
	 * build the tree
	 * @param n
	 */
	static void build(int n) {
		for (int i = n - 1; i > 0; i--){
			//segmentTree[i] = operation(segmentTree[2*i], segmentTree[2*i+1]);
			if(findHeight(n, i)%2!=0) segmentTree[i] = operation1(segmentTree[2*i], segmentTree[2*i+1]);
			else operation2(segmentTree[2*i], segmentTree[2*i+1]);
		}
	}
	/**
	 * Set the value at the given position
	 */ 
	static void singleUpdate(int position,int value,int n){
		//position^1 = position+1 if position even, otherwise position^1 = position-1 
		for(segmentTree[position+=n] = value;position>1;position/=2){
			//segmentTree[position/2] = operation(segmentTree[position],segmentTree[position^1]);
			if(findHeight(n, position/2)%2!=0) segmentTree[position/2] = operation1(segmentTree[position],segmentTree[position^1]);
			else segmentTree[position/2] = operation2(segmentTree[position],segmentTree[position^1]);
		}
	}
	 /**
	  * sum on interval [l, r)
	  * @param l
	  * @param r
	  * @param n
	  * @return
	  */
	 
	static int query(int left, int right,int n){
		int res = 0;
		for(left+=n, right+=n;left<right;left/=2,right/=2){
			if(left%2!=0) res = operation(res,segmentTree[left++]);
			if(right%2!=0) res = operation(res,segmentTree[--right]);
		}
		return res;
	}
	/**
	 * finds the height for a position
	 * leaves has height 0
	 * @param n
	 * @param position
	 * @return
	 */
	static int findHeight(int n,int position) {
		int height = 0;
		for(int p=position;p<n;p*=2) height++;
		return height;
	}
	/**
	 * Operation to Perform
	 */ 
	static int operation(int operand1,int operand2){
		return 0;
	}
	static int operation1(int operand1,int operand2){
		return operand1|operand2;
	}
	static int operation2(int operand1,int operand2){
		return operand1^operand2;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int pown = 1;
		for(int i=0;i<n;i++){
			pown*=2;
		}
		segmentTree = new int[2*pown];
		for(int i=0;i<pown;i++){
			int number = scan.nextInt();
			segmentTree[i+pown] = number;
		}
		build(pown);
		for(int i=0;i<m;i++){
			int pos = scan.nextInt();
			int value = scan.nextInt();
			singleUpdate(pos-1, value, pown);
			System.out.println(segmentTree[1]);
		}
		scan.close();
	}
}
