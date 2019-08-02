package edu.soumya.algo.graph.segmentree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BracketSequence {
	//static int[][] segmentTree;
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		long time1 = System.currentTimeMillis();
		String bracSeq = scan.nextLine();
		int len = bracSeq.length();
		int[][] segmentTree = new int[2 * len][3];
		for (int i = 0; i < len; i++) {
			if (bracSeq.charAt(i) == '(') {
				//segmentTree[len + i][0] = 0;
				segmentTree[len + i][1] = 1;
				//segmentTree[len + i][2] = 0;
			} else {
				//segmentTree[len + i][0] = 0;
				//segmentTree[len + i][1] = 0;
				segmentTree[len + i][2] = 1;
			}
		}
		build(len,segmentTree);
		int m = scan.nextInt();
		for (int i = 0; i < m; i++) {
			int start = scan.nextInt() - 1;
			int end = scan.nextInt();
			System.out.println(query(start, end, len,segmentTree));
		}
		long time2 = System.currentTimeMillis();
		//System.out.println("Time Taken:"+(time2-time1));
	}

	static void build(int n,int[][] segmentTree) {
		for (int i = n - 1; i > 0; i--) {
			operation(i, i<<1, i<<1 | 1,segmentTree);
		}
	}

	static void operation(int updIndx, int indx1, int indx2,int[][] segmentTree) {
		int leftIndex = (indx1 < indx2) ? indx1 : indx2;
		int rightIndex = (indx1 > indx2) ? indx1 : indx2;
		operationTrio(segmentTree[updIndx],segmentTree[leftIndex],segmentTree[rightIndex]);
	}

	static int[] operationTrio(int[] updTrio, int[] leftTrio, int[] rightTrio) {
		int change = Math.min(leftTrio[1], rightTrio[2]);
		updTrio[0] = leftTrio[0] + rightTrio[0] + (2*change);
		updTrio[1] = leftTrio[1] + rightTrio[1] - change;
		updTrio[2] = leftTrio[2] + rightTrio[2] - change;
		return updTrio;
	}

	static int query(int l, int r, int n,int[][] segmentTree) {
		int[] trioLeft = new int[3];
		int[] trioRight = new int[3];
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if (l % 2 != 0) {
				operationTrio(trioLeft, trioLeft, segmentTree[l++]);
			}
			if (r % 2 != 0) {
				operationTrio(trioRight, segmentTree[--r], trioRight);
			}
		}
		return operationTrio(trioLeft,trioLeft,trioRight)[0];
	}
}

class InputReader {
	BufferedReader br;
	StringTokenizer st;

	InputReader(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	int nextInt() {
		return Integer.parseInt(next());
	}
}

/*class Trio {
	public int correctSequences = 0;
	public int extraOpenBraces = 0;
	public int extraClosingBraces = 0;

	Trio() {

	}

	Trio(int correctSequences, int extraOpenBraces, int extraClosingBraces) {
		this.correctSequences = correctSequences;
		this.extraOpenBraces = extraOpenBraces;
		this.extraClosingBraces = extraClosingBraces;
	}
	
	void clear() {
		correctSequences = 0;
		extraOpenBraces = 0;
		extraClosingBraces = 0;
	}
}
*/