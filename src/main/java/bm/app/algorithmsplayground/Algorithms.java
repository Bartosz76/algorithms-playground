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
     * In the while loop, digit assumes e.g. 4, if the given number is 1234. Goes for the remnant after
     * modulo operation is performed.
     * Reversed is at first not modified by the multiplication... because reversed is 0 during the initial
     * loop. So it just assumes the value of digit.
     * The provided number is now reduced. It's an int, so multiplying it by 10 will basically just
     * remove the last digit (1234 becomes 123,4 -> remnant is discarded by int).
     * The loop begins again... this time the input is 123. Digit becomes 3. Reversed is now 4, so it
     * is multiplied by 10, in order to "make the room" for the next incoming digit. At first 4 becomes
     * 40... so when we add 3, it's 43. The number is being reversed correctly.
     * The given number is, again, reduced - 123 / 10 equals 12 (12,3 with 3 being discarded). The loop
     * goes on as long as the number isn't 0. When it becomes 0, it breaks and the reversed value is returned.
     * This algorithm is based on the idea that int ignores digits after the comma. So when it reaches it's
     * last digit - 1, then 1%10 = 0,1 (so digit assumes the value of 1) and 1/10 = 0,1 (so number, which is
     * an int, assumes the value of 0). The number is now 0, so the while loop finished its journey.
     */
    public int reverseANumberWhileLoop(int number) {

        int reversed = 0;
        int digit = 0;

        while(number != 0) {
            digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    /**
     * Reversing a number with a for loop.
     * Additionally: for(;;){//code to execute} is syntax for an infinite for loop!
     */
    public int reverseANumberForLoop(int number) {

        int reversed = 0;
        int digit = 0;

        for(; number!= 0; number /= 10) {
            digit = number % 10;
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

    /**
     * Reversing a number using recursion.
     */
    public int reverseANumberRecursion(int number) {

        if (number == 0){
            return 0;
        }
        else {
            return number % 10 * (int) Math.pow(10, (int) Math.log10(number)) + reverseANumberRecursion(number /10 );
        }
    }

    /**
     * Reversing a number by taking it as a String.
     */
    public int reverseANumberWithStringParameter(String number) {

        StringBuilder stringBuilder = new StringBuilder(number).reverse();
        return Integer.parseInt(stringBuilder.toString());
    }

    /**
     * Finding the longest common prefix for an array of Strings.
     */
    public String findTheLongestCommonPrefix(String[] arrayOfStrings) {
        if(arrayOfStrings.length == 0){
            return "";
        }
        // Initially the output assumes the value of the first element. I will compare the following ones to it.
        String output = arrayOfStrings[0];
        // Iterate through the array, omitting the first element as it's the one others are being compared to.
        for(int i = 1; i < arrayOfStrings.length; i++){
            // If indexOf() returns 0, it means that the String being checked begins with the provided
            // String. So it will iterate through all the elements over and over again, cutting the
            // last char of the String output as long as String output matches the beginning of every
            // String in the array, which will be indicated by indexOf() being equal to 0!
            while(arrayOfStrings[i].indexOf(output) != 0){
                output = output.substring(0, output.length() - 1);
            }
        }
        return output;
    }

}
