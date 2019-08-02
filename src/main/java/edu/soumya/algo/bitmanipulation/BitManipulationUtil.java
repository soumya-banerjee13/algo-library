package edu.soumya.algo.bitmanipulation;

public class BitManipulationUtil {
	/**
	 * Counts no of bits in binary representation of a number<br>
	 * Time Complexity: O(digitsEqual1) or O(log(number))<br>
	 * where, digitsEqual1 means binary digits equals 1
	 * in binary representation of the number
	 * @param number
	 * @return no of 1s in binary representation
	 */
	static int noOfOnesBinary(int number) {
		int result = 0;
		while(number>0) {
			number=number&(number-1);
			result++;
		}
		return result;
	}
}
