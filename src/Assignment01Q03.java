public class Assignment01Q03 {
    /**
     * Calculates first [X] numbers in the Fibonacci sequence,
     * and how many of them are odd numbers.
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");
        
        ////////////////////////////////////////////////////////////////

        int numOdd = 0;
        int prev_2 = 0, prev_1 = 1, curr = 1;
        for (int i = 0; i < x; i++) {
            System.out.print(curr);
            curr = prev_2 + prev_1;
            prev_2 = prev_1;
            prev_1 = curr;
            if (curr % 2 == 1) numOdd++;
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
