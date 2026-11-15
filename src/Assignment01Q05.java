public class Assignment01Q05 {
    /**
     * Initializes an array full of a certain value.
     */
    public static int[] initArray(int len, int val) {
        int[] arr = new int[len];
        for (int x = 0; x < len; x++) {
            arr[x] = val;
        }
        return arr;
    }

    /**
     * Finds the minimal value in an array.
     */
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < min) {min = arr[j];}
        }
        return min;
    }

    /**
     * Finds the length of the shortest possible path between two nodes (i,j) based off their connections matrix.
     * @param m - matrix showing connections between graph nodes (0 - no connection, 1 - connection)
     * @param i - source node the path is from
     * @param j - node to find the path to
     * @return the length of the shortest path.
     */
    public static int findShortestPath(int[][] m, int i, int j) {
        int[] dist_from_i = initArray(m.length, m.length+1);
        int curr_dist = 0;
        int x = findPathLen(m, i, j, dist_from_i, curr_dist);
        if (x > m.length) {return -1;}
        return x;
    }


    /**
     * Recursively finds the paths between two nodes (i,j) based off their connections matrix, 
     * separating according to the first node jumped to.
     * Saves the possible paths and returns only the shortest one.
     */
    public static int findPathLen(int[][] m, int start, int end, int[] dist_from_i, int curr_dist){
        if (start == end) {return 0;}  // starting at destination.
        if (m[start][end] == 1) {return curr_dist + 1;} // 
        if (curr_dist > m.length) {return m.length + 1;}
        for (int x = 0; x < m.length; x++) {
            if (m[start][x] == 0) {continue;}
            if (m[start][x] == 1) {
                dist_from_i[start] = findPathLen(m, x, end, dist_from_i, curr_dist + 1);}
            }
        return findMin(dist_from_i);
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}