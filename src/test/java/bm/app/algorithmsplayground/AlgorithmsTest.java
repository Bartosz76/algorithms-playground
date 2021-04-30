package bm.app.algorithmsplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlgorithmsTest {

    Algorithms algorithms;

    @Test
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
    void whileLoopShouldReverseAGivenNumber() {
        //given
        int givenNumber = 54867;
        int expectedResult = 76845;
        //when
        int result = algorithms.reverseANumberWhileLoop(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void forLoopShouldReverseAGivenNumber() {
        //given
        int givenNumber = 876;
        int expectedResult = 678;
        //when
        int result = algorithms.reverseANumberForLoop(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void recursionShouldReverseAGivenNumber() {
        //given
        int givenNumber = 7431;
        int expectedResult = 1347;
        //when
        int result = algorithms.reverseANumberRecursion(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @BeforeEach
    void setUp() {
        algorithms = new Algorithms();
    }

}