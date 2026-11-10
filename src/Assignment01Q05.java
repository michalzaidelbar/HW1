public class Assignment01Q05 {
    /**
     * Creates array full of zeroes of chosen length.
     * @param len - length of array.
     * @return Array of length <len> full of zeroes.
     */
    private static int[] createZeroArr(int len) {
        int[] zero_arr = new int[len];
        for (int x = 0; x < len; x++) {zero_arr[x] = 0;}
        return zero_arr;

    }

    public static int findPathLen(int[][] m, int i, int j) {
        int[] visited_nodes = new int[m.length];
        visited_nodes[0] = i;
        return visited_nodes.length;
    }
    
    /**
     * Finds the length of the shortest possible path between two nodes (i,j) based off their connections matrix.
     * @param m - matrix showing connections between graph nodes (0 - no connection, 1 - connection)
     * @param i - source node the path is from
     * @param j - node to find the path to
     * @return the length of the shortest path.
     */
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {return 0;}
        else if (m[i] == createZeroArr(m.length)) {return -1;} // i row is only zeroes -> no way forward

        else {
        int[] paths_lens = createZeroArr(m.length);
        for (int x = 0; x < m.length; x++) {
            if (m[i][x] == 1) {paths_lens[x] = findPathLen(m, x, j);}
            }
            // TODO: FINISH THIS
        System.out.println(paths_lens);
        }  
        return -1;
    }

    public static void main(String[] args) {
        // System.out.println(
        //     findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        // System.out.println(
        //     findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}