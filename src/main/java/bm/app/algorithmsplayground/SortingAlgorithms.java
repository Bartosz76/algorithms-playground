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
     *
     * Mergesort is used when the data structure doesn't support random access as it works
     * with purely sequential access (forward iterators, not random access iterators). It's used
     * widely for an external sorting where random access can be expensive in comparison to
     * sequential access (e.g. when the file to sort doesn't fit into memory, break it into
     * smaller chunks that do fit and sort them independently).
     * Mergesort is also a stable sort.
     * It's quicker with linked lists due to the pointers being easy to change when merging
     * collections. It only requires a single pass through the collection, so O(n).
     * If there's a lot of parallelization, Mergesort is simpler than other algorithms.
     */
    public void mergeSort(Comparable[] providedCollection) {
        // If the collection is empty - no need to do a thing.
        if (providedCollection.length <= 1) {
            return;
        }

        // Split the collection in half into two sub-collections.
        Comparable[] first = new Comparable[providedCollection.length / 2];
        Comparable[] second = new Comparable[providedCollection.length - first.length];
        System.arraycopy(providedCollection, 0, first, 0, first.length);
        System.arraycopy(providedCollection, first.length, second, 0, second.length);

        // Sort both halves recursively.
        mergeSort(first);
        mergeSort(second);

        // Merge both halves together, overwriting the original provided collection.
        merge(first, second, providedCollection);
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

    /**
     * Insertion algorithm.
     * This algorithm repeatedly takes the next element from the not-yet-sorted section and
     * inserts it into the sorted one at the correct position.
     * The steps of this algorithm are:
     * - data elements are grouped into two sections: the sorted and the un-sorted one,
     * - an element of the un-sorted one is taken,
     * - said element is inserted into the sorted section at the position determined by
     *   the comparable property,
     * - rinse and repeat until the un-sorted section is emptied.
     *
     * This algorithm is efficient for small data inputs. It is also adaptive - it's quite
     * efficient if the input is already substantially sorted. Moreover, it's stable - it
     * does not change the relative order of the elements with equal keys.
     *
     * This is a simple version.
     */
    public void insertionSort(Object[] providedObject, int fromIndex, int toIndex) {
        Object temporaryHolder;
        for (int i = fromIndex + 1; i < toIndex; i++) {
            temporaryHolder = providedObject[i];
            int j = i;
            while (j > fromIndex && ((Comparable) providedObject[j - 1]).compareTo(temporaryHolder) > 0) {
                providedObject[j] = providedObject[j - 1];
                j--;
            }
            providedObject[j] = temporaryHolder;
        }
    }
    /**
     * This is an improved version. We are employing a binary search algorithm here.
     * It can be a better choice for collections that are already partly sorted.
     */
    public void insertionSortImproved(Object[] providedCollection, int fromIndex, int toIndex)
    {
        Object temporaryHolder;
        for (int i = fromIndex + 1; i < toIndex; i++)
        {
            temporaryHolder = providedCollection[i];
            int jLeft = fromIndex;
            int jRight = i - 1;
            // Check if its current position is its suitable position.
            if (((Comparable) providedCollection[jRight]).compareTo(temporaryHolder) > 0)
            {
                // Perform the binary search.
                while (jRight - jLeft >= 2)
                {
                    int jMiddle = (jRight - jLeft) / 2 + jLeft - 1;
                    if (((Comparable) providedCollection[jMiddle]).compareTo(temporaryHolder) > 0) {
                        jRight = jMiddle;
                    } else {
                        jLeft = jMiddle + 1;
                    }
                }
                if (jRight - jLeft == 1)
                {
                    int jMiddle = jLeft;
                    if (((Comparable) providedCollection[jMiddle]).compareTo(temporaryHolder) > 0) {
                        jRight = jMiddle;
                    } else {
                        jLeft = jMiddle + 1;
                    }
                }
                // Place the element.
                int j = i;
                for (j = i; j > jLeft; j--)
                {
                    providedCollection[j] = providedCollection[j - 1];
                }
                providedCollection[j] = temporaryHolder;
            }
        }
    }
}
