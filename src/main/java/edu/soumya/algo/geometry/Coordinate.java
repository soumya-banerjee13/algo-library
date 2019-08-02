package edu.soumya.algo.geometry;

public class Coordinate implements Comparable<Coordinate>{
	int xAxis;
	int yAxis;
	Coordinate(int x, int y) {
		xAxis = x;
		yAxis = y;
	}
	public int compareTo (Coordinate otherCoordinate) {
		long multiplier = 1000000000L;
		long thisComp = (this.xAxis*multiplier)+this.yAxis;
		long otherComp = (otherCoordinate.xAxis*multiplier)+otherCoordinate.yAxis;
		return (thisComp>otherComp)?1:(thisComp<otherComp)?-1:0;
	}
}
