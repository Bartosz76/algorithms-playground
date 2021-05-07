package bm.app.algorithmsplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlgorithmsTest {

    Algorithms algorithms;

    @Test
    @DisplayName("Should reverse a given String.")
    void shouldReverseAGivenString() {
        //given
        String givenString = "Pikachu";
        String expectedString = "uhcakiP";
        //when
        String result = algorithms.reverseAString(givenString);
        //then
        assertThat(result).isEqualTo(expectedString);
    }

    @Test
    @DisplayName("Should reverse a provided number by using a while loop.")
    void shouldReverseAGivenNumberWithWhileLoop() {
        //given
        int givenNumber = 54867;
        int expectedResult = 76845;
        //when
        int result = algorithms.reverseANumberWhileLoop(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should reverse a provided number by using a for loop.")
    void shouldReverseAGivenNumberWithForLoop() {
        //given
        int givenNumber = 876;
        int expectedResult = 678;
        //when
        int result = algorithms.reverseANumberForLoop(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should reverse a given number by using recursion.")
    void shouldReverseAGivenNumberWithRecursion() {
        //given
        int givenNumber = 7431;
        int expectedResult = 1347;
        //when
        int result = algorithms.reverseANumberRecursion(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should reverse a given number by taking the input as a String.")
    void shouldReverseAGivenNumberWithStringParameter() {
        //given
        String number = "69546";
        int expectedResult = 64596;
        //when
        int result = algorithms.reverseANumberWithStringParameter(number);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should find the longest common prefix of all String provided within the array.")
    void shouldFindTheLongestCommonPrefix() {
        //given
        String[] arrayOfString = {"skis", "skirt", "sky", "skin"};
        String expectedResult = "sk";
        //when
        String result = algorithms.findTheLongestCommonPrefix(arrayOfString);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should remove one character of a provided String in such a manner that the" +
            "yielded result will be the smallest possible String")
    void shouldRemoveOneCharacterToCreateLexicographicallyTheSmallestPossibleString() {
        //given
        String providedString = "abcda";
        String expectedResult = "abca";
        //when
        String actualResult = algorithms.findTheLexicographicallySmallestPossibleStringByRemovingOneChar(providedString);
        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnTrueWhenOccurencesOfAAreBeforeB() {
        //given
        String providedInput = "aabb";
        //when
        boolean result = algorithms.ifOccurencesOfAAreBeforeB(providedInput);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenNotAllOccurencesOfAAreBeforeB() {
        //given
        String providedInput = "aabba";
        //when
        boolean result = algorithms.ifOccurencesOfAAreBeforeB(providedInput);
        //then
        assertThat(result).isFalse();
    }

    @BeforeEach
    void setUp() {
        algorithms = new Algorithms();
    }

}