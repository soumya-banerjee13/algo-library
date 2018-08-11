public class TimeSavingAffair {
    // Complete the leastTimeToInterview function below.
    static long leastTimeToInterview(int n, int k, int m) {
        // Return the least amount of time needed to reach the interview location in seconds.
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++) {
            nodes[i] = new Node();   
        }
        for(int i=0;i<m;i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            if(source == dest) continue;
            Edge edge1 = new Edge(source-1,dest-1,weight);
            //Edge Edge = new Edge(dest,source,weight);
            nodes[source-1].getEdges().add(edge1);
            nodes[dest-1].getEdges().add(edge1);
        }
        nodes[0].setDistanceFromSource(0);
        int nextNode = 0;
        for(int i=0;i<n;i++){
            ArrayList<Edge> currentNodeEdges = nodes[nextNode].getEdges();
            for(int j=0;j<currentNodeEdges.size();j++) {
                int neighbourIndex = currentNodeEdges.get(j).getNeighbourIndex(nextNode);
                if (neighbourIndex == -1) {
                    continue;
                }
                if(!nodes[neighbourIndex].isVisited()) {
                    long calculatedDistance = nodes[nextNode].getDistanceFromSource() + (long)currentNodeEdges.get(j).getWeight();
                    if((nodes[nextNode].getDistanceFromSource()/k)%2 != 0) {
                        calculatedDistance += (long)k - (nodes[nextNode].getDistanceFromSource() % (long)k);
                    }
                    if(calculatedDistance < nodes[neighbourIndex].getDistanceFromSource()) {
                        nodes[neighbourIndex].setDistanceFromSource(calculatedDistance);
                    }
                }
            }
            nodes[nextNode].setVisited(true);
            int probableNextNode = getNodeShortestDistance(n,nodes);
            if(probableNextNode != -1) {
                nextNode = probableNextNode;
            }
        }
        return nodes[n-1].getDistanceFromSource();
    }
    static int getNodeShortestDistance(int n,Node[] nodes) {
        int storedNodeIndex = -1;
        long storedDistance = Long.MAX_VALUE;
        for(int i=0;i<n;i++) {
            long currentDistance = nodes[i].getDistanceFromSource();
            if (!nodes[i].isVisited() && currentDistance<storedDistance) {
                storedDistance = currentDistance;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = leastTimeToInterview(n, k, m);

        System.out.println(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}