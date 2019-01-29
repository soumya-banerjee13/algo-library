package edu.soumya.algo.graph;

/** 
 * <p>
 * Disjoint Set data structure is useful for the problems,
 * where all connected components of a graph needs to be determined.<br>
 * 
 * Disjoint Sets have two main methods union and find<br>
 * 
 * union: Generally connects two components together.<br>
 * find: Used to determine a node belongs to which 
 * component.<br>
 * 
 * In the below implementation of Disjoint Set, Path Compression
 * and Union by Rank techniques are used together.<br>
 * These two techniques 
 * complement each other and amortized time per operation(union or find)
 * becomes <b>O(f(n))</b>,<br>
 * where <b>f(n)</b> is the
 * <a href="https://en.wikipedia.org/wiki/Ackermann_function#Inverse">Inverse Ackermann function</a>
 * which is very close to <b>O(1)</b>.
 * </p>
 * 
 * @author Soumya Banerjee
 */
public class DisjointSet {

    int noOfNodes;
    int largestSetNodes;
    int[] parents;
    int[] rank;
    int[] size;
    /**
     * <p>
     * Constructor Method for Disjoint Set<br>
     * Initializes the data structure with<br>
     * the total no. of nodes or elements
     * </p>
     * @param noOfNodes
     */
    DisjointSet(int noOfNodes) {
        this.noOfNodes = noOfNodes;
        parents = new int[noOfNodes+1];
        rank = new int[noOfNodes+1];
        size = new int[noOfNodes+1];
        for(int i=0;i<=noOfNodes;i++) {
            parents[i]=i;
            rank[i]=0;
            size[i]=1;
        }
        largestSetNodes = 1;
    }
    /**
     * <p>
     * find method here is using path compression technique,<br>
     * without using the technique worst case time complexity<br>
     * of find method would have been O(n).
     * </p>
     * @param node
     * @return
     */
    int find(int node) {
        if(node!=parents[node]) {
            parents[node]=find(parents[node]);
        }
        return parents[node];
    }
    /**
     * <p>
     * unite method is actually union<br>
     * of one component with another,<br>
     * here unite is using path compression of<br>
     * find method and performing union by rank<br>
     * </p>
     * @param firstNode
     * @param secondNode
     * @return
     */
    boolean unite(int firstNode,int secondNode) {
        int firstComponentIdentifier = find(firstNode);
        int secondComponentIdentifier = find(secondNode);
        if(firstComponentIdentifier != secondComponentIdentifier) {
            if(rank[firstComponentIdentifier] < rank[secondComponentIdentifier]) {
            	parents[firstComponentIdentifier] = secondComponentIdentifier;
                size[secondComponentIdentifier] += size[firstComponentIdentifier];
                largestSetNodes = Math.max(largestSetNodes,size[secondComponentIdentifier]);
            }else {
            	parents[secondComponentIdentifier] = firstComponentIdentifier;
                size[firstComponentIdentifier] += size[secondComponentIdentifier];
                largestSetNodes = Math.max(largestSetNodes,size[firstComponentIdentifier]);
            }
            if(rank[firstComponentIdentifier] == rank[secondComponentIdentifier]) {
                rank[firstComponentIdentifier]++;
            }
            return true;
        }
        return false;
    }
}
