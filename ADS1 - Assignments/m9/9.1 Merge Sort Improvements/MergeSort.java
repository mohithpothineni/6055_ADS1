
/**
 * Class for merge.
 */
class MergeSort {

    /**
     * threshold value for calling insertion sort.
     */
    private final int x = 7;

    /**
     * Constructs the object.
     */
    MergeSort() {

    }

    /**
     * Method to merge two arrays.
     * Time complexity : O(N).
     * It iterates over the number of elementds in the two subarray
     * so complexity tends to no of elementscombined in those arrays.
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower value
     * @param      mid    The middle value
     * @param      hi     The higher value
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
                      final int lo, final int mid, final int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > hi) {
                aux[k] = array[i++];
            } else if (InsertionSort.less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
    }

    /**
     * Method for sorting.
     * Time complexity : O(Nlog(N)).
     * According to the depth of decission tree made the complexity
     * will be of logarithmic of n to the base 2.
     *
     * @param      array  The array
     * @param      aux    The auxiliary array
     * @param      lo     The lower value
     * @param      hi     The higher value
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
                     final int lo, final int hi) {
        if (hi <= lo + x) {
            InsertionSort.insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, array, lo, mid);
        sort(aux, array, mid + 1, hi);
        if (!InsertionSort.less(array[mid + 1], array[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * Time complexity : O(N).
     * cloning takes n iterations for copying.
     *
     * @param      a     Comparable array.
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }


    /**
     * Method to print the values of the Comparable array.
     * Time complexity of this method is O(N).
     * As it iterates all over the array.
     * @param      a     Name of object array
     *
     * @return     String representation.
     */
    public String print(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
}
