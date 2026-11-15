public class Assignment01Q02 {
    /**
     * Estimates pi based on the 4arctan(1) approximation,
     * up to given natural number of arguments. <br>
     * For example, given the input "5", will calculate: <br>
     * approxPi = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9)
     */
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int exactness = Integer.parseInt(args[0]);
        double add = 4;
        for (double i = 0; i < exactness; i++) {
            approxPi += add * (1/(2*i+1));
            add = add * -1; // every other element must add / subtract
        }
        
        System.out.println(approxPi + " " + actualPi);
    }
}
