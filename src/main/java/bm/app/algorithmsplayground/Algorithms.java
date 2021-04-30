package bm.app.algorithmsplayground;

public class Algorithms {

    public static void main(String[] args) {
    }

    /**
     * This is basically an algorithm repository. :)
     */

    /**
     * Reversing a String.
     */
    public String reverseAString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    /**
     * Reversing a number.
     */
    public int reverseANumber(int number) {

        int reversed = 0;
        int digit = 0;

        while(number != 0) {
            digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}
