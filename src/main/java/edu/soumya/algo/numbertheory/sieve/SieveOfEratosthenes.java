package edu.soumya.algo.numbertheory.sieve;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * Below is the implementation of Sieve of Eratosthenes.<br>
 * Sieve is useful to determine all primes and prime factors
 * of all Composite numbers,<br>
 * within a given range.<br>
 * 
 * <br>
 * Method to test the sieve is also inside
 * the class<br>
 * 
 * <br>
 *  Time complexity of the algorithm<br>
 *  for 0 to N numbers is
 *  <b>O(N log (log N))</b>
 * 
 * </p>
 * 
 * @author Soumya Banerjee
 *
 */
public class SieveOfEratosthenes {
	public static final int limit = 100000;
	static boolean[] visited;
	static boolean[] primes;
	static List<List<Integer>> adjacent;
	public static void main(String[] args) {
		sieve();
		System.out.println("All primes upto limit");
		for(int i=0;i<=limit;i++) {
			if(primes[i]) {
				System.out.println(i);
			}
		}
		Random rand = new Random();
		int randomInt = rand.nextInt(100000);
		System.out.println("Prime factors of "+ randomInt +" are :");
		for(int i : (ArrayList<Integer>)adjacent.get(randomInt)) {
			System.out.print(i+" ");
		}
	}
	/**
	 * Generating sieve for the given range
	 * using Eratosthenes algorithm
	 */
	private static void sieve() {
		visited = new boolean[limit+1];
		adjacent = new ArrayList<List<Integer>>();
		primes = new boolean[limit+1];
		for(int i=0;i<=limit;i++) {
			adjacent.add(new ArrayList<Integer>());
		}
		for(int i=2;i<=limit;i++) {
			if(!visited[i]) {
				int j = i;
				primes[i] = true;
				while(j<=limit) {
					visited[j] = true;
					//adding all prime factors of every number
					adjacent.get(j).add(i);
					j+=i;
				}
			}
		}
	}
}
