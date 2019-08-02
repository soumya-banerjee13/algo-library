package edu.soumya.algo.numbertheory;

public class NumberTheoryUtil {
	static int gcd(int a,int b) {
		int greater = Integer.MAX_VALUE;
		int smaller = Integer.MIN_VALUE;
		if(a>b) {
			greater = a;
			smaller = b;
		} else {
			greater = b;
			smaller = a;
		}
		if(greater%smaller==0) {
			return smaller;
		} else {
			return gcd(smaller,greater%smaller);
		}
	}
	
	static int lcm(int a,int b) {
		int mul = a*b;
		return mul/gcd(a,b);
	}
	
	//To calculate (a^b) %c
	static int fastModularExponent(int base,int exponent,int mod) {
		int result = 1;
		//update base if it is >= mod
		base = base%mod;
		while(exponent>0) {
			if((exponent&1)==1) {
				//Converting to long to avoid overflow during multiplication
				result=(int)(((long)result*base)%mod);
			}
			exponent>>=1;
			base=(int)(((long)base*base)%mod);
		}
		return result;
	}
	//To calculate Very Big Number(given as string) % small number
	static int bigNumberMod(String bigNumber,int mod) {
		int result = 0;
		int dgtInBigNumber = bigNumber.length();
		for(int i=0;i<dgtInBigNumber;i++) {
			result = ((result*10)+(int)(bigNumber.charAt(i)-'0'))%mod;
		}
		return result;
	}
}
