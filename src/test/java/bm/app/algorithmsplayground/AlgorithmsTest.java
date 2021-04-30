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
    void shouldReverseAGivenNumber() {
        //given
        int givenNumber = 54867;
        int expectedResult = 76845;
        //when
        int result = algorithms.reverseANumber(givenNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @BeforeEach
    void setUp() {
        algorithms = new Algorithms();
    }

}