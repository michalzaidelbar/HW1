import java.util.Arrays;

public class Assignment01Q04 {
    private static String valid_dirs = "RL";
    /**
     * Shifts integers in a given array by a given number of positions left or right.
     * @param array list of integers.
     * @param move number of positions to shift integers by.
     * @param direction R (right) or L (left).
     * @return Array after being shifted.
     */
    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (valid_dirs.contains(Character.toString(direction)) && move != 0 && array.length != 0) {
            if (move < 0) {
                // swaps direction if move is negative
                direction = (direction == 'R') ? 'L' : 'R';
                move = -1 * move;
            }
            int len = array.length;
            int shift_by = move % len;
            // Shifting a list by N rightwards is equivalent to taking the last N elements,
            // and then the first (len - N) elements.
            // Shifting N leftwards is like shifting (len - N) rightwards.
            shift_by = (direction == 'L') ? len - shift_by : shift_by;
            // Store old first / new last elements
            int[] temp_array = Arrays.copyOfRange(array, 0, len - shift_by);
            for (int i = 0; i < len; i++) {
                array[i] = (i < shift_by) ? array[i + len - shift_by] : temp_array[i - shift_by];
            }
        }
        
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}