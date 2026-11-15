public class Assignment01Q01 {
    /** 
     * Returns first character of each input string 
     * if its ascii value divides by five.
    */
    public static void main(String[] args) {
        for (String arg: args) {
            char first_ch = arg.charAt(0);
            if ((int) first_ch % 5 == 0) {
                System.out.println(first_ch);
            };
        }
    }
}
