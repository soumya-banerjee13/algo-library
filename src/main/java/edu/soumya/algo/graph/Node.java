package edu.soumya.algo.graph;

import java.util.ArrayList;
public class Node {
  private long distanceFromSource = Integer.MAX_VALUE;
  private boolean visited;
  private ArrayList<Edge> edges = new ArrayList<Edge>(); // now we must create edges
  public long getDistanceFromSource() {
    return distanceFromSource;
  }
  public void setDistanceFromSource(long distanceFromSource) {
    this.distanceFromSource = distanceFromSource;
  }
  public boolean isVisited() {
    return visited;
  }
  public void setVisited(boolean visited) {
    this.visited = visited;
  }
  public ArrayList<Edge> getEdges() {
    return edges;
  }
  public void setEdges(ArrayList<Edge> edges) {
    this.edges = edges;
  }
}