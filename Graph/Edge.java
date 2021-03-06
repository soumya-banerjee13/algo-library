public class Edge {
  private int fromNodeIndex;
  private int toNodeIndex;
  private int weight;
  public Edge(int fromNodeIndex, int toNodeIndex, int weight) {
    this.fromNodeIndex = fromNodeIndex;
    this.toNodeIndex = toNodeIndex;
    this.weight = weight;
  }
  public int getFromNodeIndex() {
    return fromNodeIndex;
  }
  public int getToNodeIndex() {
    return toNodeIndex;
  }
  public int getWeight() {
    return weight;
  }
  // determines the neighbouring node of a supplied node, based on the two nodes connected by this edge
  public int getNeighbourIndex(int nodeIndex) {
    if (this.fromNodeIndex == nodeIndex) {
      return this.toNodeIndex;
    } else {
      return this.fromNodeIndex;
   }
  }
}