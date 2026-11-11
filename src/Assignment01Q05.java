public class Assignment01Q05 {
    /**
     * Finds the length of the shortest possible path between two nodes (i,j) based off their connections matrix.
     * @param m - matrix showing connections between graph nodes (0 - no connection, 1 - connection)
     * @param i - source node the path is from
     * @param j - node to find the path to
     * @return the length of the shortest path.
     */
    public static int findShortestPath(int[][] m, int i, int j) {
        int dist_from_i = 0;
        boolean[] visited = new boolean[m.length];
        visited[i] = true;
        for (int x = 0; x < m.length; x++) {
            if (visited[x]) {continue;}
            if (m[i][x] == 0) {continue;}
            if (m[i][x] == 1) {visited[x] = true; dist_from_i++;}
            }
        System.out.println(dist_from_i);
        return -1;
    }

    public static void main(String[] args) {
        // System.out.println(
        //     findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        // System.out.println(
        //     findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        // System.out.println(
        //     findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}