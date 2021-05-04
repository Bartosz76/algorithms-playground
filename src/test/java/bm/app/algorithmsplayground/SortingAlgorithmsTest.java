package bm.app.algorithmsplayground;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmsTest {

    SortingAlgorithms sortingAlgorithms;

    @Test
    void shouldSortTheProvidedCollectionByMergeSort() {
        //given
        Integer[] providedArray = {23, 5, 6, 21, 8, 76, 3, 21};
        Integer[] expectedResult = {3, 5, 6, 8, 21, 21, 23, 76};
        //when
        Integer[] actualResult = (Integer[]) sortingAlgorithms.mergeSort(providedArray);
        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @BeforeEach
    void setUp() {
        sortingAlgorithms = new SortingAlgorithms();
    }



}