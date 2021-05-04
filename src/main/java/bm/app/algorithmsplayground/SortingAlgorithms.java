package bm.app.algorithmsplayground;

public class SortingAlgorithms {

    /**
     * Mergesort algorithm. O(n log n).
     * Divide and conquer kind of an algorithm. It divides the original data into smaller
     * sets to solve the problem.
     * The collection being sorted is divided into two collections. In order to perform
     * that split, Mergesort takes the middle element of the initial collection and
     * breaks it there into two. The process continues for the collections that resulted
     * from the previous split and so forth until there is a single element in each
     * collection.
     * Then the elements are being combined back again. Two are being compared and the
     * lower one is being inserted first into the new collection. This new collection
     * is being compared to another collection that came to be in the same manner.
     * The process builds the initial collection back up again, but this time with its
     * elements sorted.
     * The concept of the Mergesort is:
     * - divide the unsorted collection into two sub-collections of about half the size
     * of the initial collection each,
     * - sort the sub-collections,
     * - merge the sorted sun-collections back into a single sorted one.
     */
    public Comparable[] mergeSort(Comparable[] collection) {
        // If the collection is empty - no need to do a thing.
        if (collection.length <= 1) {
            return collection;
        }

        // Split the collection in half into two sub-collections.
        Comparable[] first = new Comparable[collection.length / 2];
        Comparable[] second = new Comparable[collection.length - first.length];
        System.arraycopy(collection, 0, first, 0, first.length);
        System.arraycopy(collection, first.length, second, 0, second.length);

        // Sort both halves recursively.
        mergeSort(first);
        mergeSort(second);

        // Merge both halves together, overwriting the original provided collection.
        merge(first, second, collection);
        return collection;
    }

    private void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        // Index' position in the first array - starting with the first element.
        int indexFirst = 0;

        // Index' position in second array - starting with the first element.
        int indexSecond = 0;

        // Index' position in merged array - starting with the first position.
        int indexMerged = 0;

        // Compare the elements at indexFirst and indexSecond and move the smaller element at indexMerged.
        while (indexFirst < first.length && indexSecond < second.length) {
            if (first[indexFirst].compareTo(second[indexSecond]) < 0) {
                result[indexMerged] = first[indexFirst];
                indexFirst++;
            } else {
                result[indexMerged] = second[indexSecond];
                indexSecond++;
            }
            indexMerged++;
        }
        // Copy the remaining elements from both halves - each half will have already sorted elements.
        System.arraycopy(first, indexFirst, result, indexMerged, first.length - indexFirst);
        System.arraycopy(second, indexSecond, result, indexMerged, second.length - indexSecond);
    }
}
