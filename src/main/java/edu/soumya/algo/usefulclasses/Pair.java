package edu.soumya.algo.usefulclasses;

public class Pair implements Comparable<Pair>{
	int major;
	int minor;
	Pair(int a,int b){
		this.major = a;
		this.minor = b;
	}
	public int getMajor() {
		return this.major;
	}
	public int getMinor() {
		return this.minor;
	}
	@Override
	public int compareTo(Pair pair) {
		if(this.major<pair.major){
			return -1;
		} else if(this.major>pair.major){
			return 1;
		} else if(this.minor<pair.minor){
			return -1;
		} else if(this.minor>pair.minor){
			return 1;	
		} else{
			return 0;
		}
	}
	@Override
	public boolean equals(Object obj){
		Pair pair = (Pair)obj;
		return (this.major==pair.major);
	}
	@Override
	public int hashCode() {
		return major*32+minor;
	}
}