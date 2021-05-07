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

    /**
     * Finding the lexicographically smallest String formed by removing one character.
     * The idea is to have a String and remove from it the character which absence will
     * yield the smallest lexicographically String possible left.
     *
     */
    public String findTheLexicographicallySmallestPossibleStringByRemovingOneChar(String providedString) {
        int length = providedString.length();
        String answer = "";
        for (int i = 0; i < length - 1; i++) {
            // Find the point where the character is larger than the one that follows.
            if (providedString.charAt(i) > providedString.charAt(i + 1)) {
                // At that point -> loop again and create a new String consisting of
                // every other character that is different from the found one.
                for (int j = 0; j < length; j++) {
                    if (i != j) {
                        answer += providedString.charAt(j);
                    }
                }
                return answer;
            }
        }
        // If we're here -> it means that no preceding element is larger than the
        // following, so either the largest one is at the end or the String is made
        // of identical characters. Either way -> remove that last element.
        answer = providedString.substring(0, length - 1);
        return answer;
    }

    /**
     * A function that given a String, consisting of letters 'a' and/or 'b', returns
     * true when occurences of 'a' are before 'b'.
     */
    public boolean ifOccurencesOfAAreBeforeB(String providedString) {
        int length = providedString.length() - 1;
        // Declare support variables to "keep the state".
        int index = 0;
        // This variable will be changed (or not) depending on which letter, 'a' or 'b'
        // will be the last.
        int state = 1;
        int bMarker = 0;
        // Iterate through all characters of the provided String looking for occurences
        // of every letter.
        while (length >= 0) {
            if (providedString.charAt(index) == 'a') {
                // When I find 'a', we increment i, to keep
                // iterating.
                index++;
                length--;
                // If the expected state of bMarker is met, I break the
                // loop because that state (bMarker being 1) can happen only if a found
                // character is 'b' and since I found myself in this 'if' again...
                // It means that the following character was 'a'. Which means we're
                // returning 'false'.
                if (bMarker == 1) {
                    state = 0;
                    break;
                }
            } else if (providedString.charAt(index) == 'b') {
                // If 'b' was found, we change bMarker to indicate that and we go back
                // into the loop with that information.
                bMarker = 1;
                index++;
                length--;
            }
        }
        // state can change from 1 to 0 only if the loop every fell into 'if' 'b' loop
        // and then returned to 'if' 'a' loop. If that happened, that means there was an
        // occurence of 'a' after an occurence of 'b'.
        if (state == 0) {
            return false;
        } else {
            return true;
        }
    }
}
