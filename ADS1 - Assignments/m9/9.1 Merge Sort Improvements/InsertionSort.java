/**
 * Class for insertion sort.
 */
final class InsertionSort {

    /**
     * Constructs the object.
     */
    private InsertionSort() {

    }

    /**
     * Method for insertion sort.
     * sort from a[lo] to a[hi].
     * Time complexity : O(N^2/2).
     * It takes two loops for iterating over
     * main array and iterating over sub array
     * tending to the complexity of n squared where n is the no of inputs.
     *
     *
     * @param      a     Comparable array.
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public static void insertionSort(final Comparable[] a,
                                     final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }


    /**
     * Method to exchange two elements in the array.
     * Time complexity :  O(1).
     * constant time for swapping.
     *
     * @param      a     Array of object
     * @param      i     Integer i
     * @param      j     Integer j
     */
    public static void exchange(final Comparable[] a,
                                final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Method to check which one is smaller of the two.
     * Time complextiy : O(1).
     * constant time for checking.
     *
     * @param      a     Comparable.
     * @param      b     Comparable.
     *
     * @return     true if less else false.
     */
    public static boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

}
