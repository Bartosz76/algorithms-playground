package bm.app.algorithmsplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmsTest {

    SortingAlgorithms sortingAlgorithms;

    @Test
    @DisplayName("The provided collection should be sorted with the help of the Mergesort.")
    void shouldSortTheProvidedCollectionByMergeSort() {
        //given
        Integer[] providedArray = {23, 5, 6, 21, 8, 76, 3, 21};
        Integer[] expectedResult = {3, 5, 6, 8, 21, 21, 23, 76};
        //when
        sortingAlgorithms.mergeSort(providedArray);
        //then
        assertThat(providedArray).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("The provided collection should be sorted with the help of the Insertion sort in its simple version.")
    void shouldSortTheProvidedCollectionByInsertionSortSimpleWay() {
        //given
        Integer[] providedArray = {9, 18, 2, 3, 56, 213, 1, 0, 0};
        Integer[] expectedResult = {0, 0, 1, 2, 3, 9, 18, 56, 213};
        //when
        sortingAlgorithms.insertionSort(providedArray, 0, providedArray.length);
        //then
        assertThat(providedArray).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("A select part of the provided collection should be sorted with the help of the Insertion sort in its simple version.")
    void shouldSortOnlyAPartOfTheProvidedCollectionByInsertionSortSimpleWay() {
        //given
        Integer[] providedArray = {287, 2, 3, 456, 2, 78};
        Integer[] expectedArray = {287, 2, 3, 2, 78, 456};
        //when
        sortingAlgorithms.insertionSort(providedArray, 3, providedArray.length);
        //then
        assertThat(providedArray).isEqualTo(expectedArray);
    }

    @Test
    @DisplayName("The provided collection should be sorted with the help of the Insertion sort in its improved version.")
    void shouldSortTheProvidedCollectionByInsertionSortImprovedWay() {
        //given
        Integer[] providedArray = {3, 98, 6, 34, 235, 0, 8, 0, 433};
        Integer[] expectedResult = {0, 0, 3, 6, 8, 34, 98, 235, 433};
        //when
        sortingAlgorithms.insertionSortImproved(providedArray, 0, providedArray.length);
        //then
        assertThat(providedArray).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("The provided array should be sorted with the help of Bubblesort.")
    void shouldSortTheProvidedArrayByBubbleSort() {
        //given
        int[] providedArray = {8, 0, 5, 0, 2, 1, 567, 23, 1};
        int[] expectedResult = {0, 0, 1, 1, 2, 5, 8, 23, 567};
        //when
        sortingAlgorithms.bubbleSort(providedArray);
        //then
        assertThat(providedArray).isEqualTo(expectedResult);
    }

    @BeforeEach
    void setUp() {
        sortingAlgorithms = new SortingAlgorithms();
    }



}