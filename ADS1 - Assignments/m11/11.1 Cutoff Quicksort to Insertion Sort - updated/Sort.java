
/**class for sort.
 *
 */
class Sort {
    /**
     * Constructs the object.
     */
    Sort() {
    }

    /**
     * sort the given array.
     *
     * @param      arr  The array
     * @param      lo   lowest index
     * @param      hi   highest index
     * time complexity for this method is O(N^2).
     */
    public void insertion(final Comparable[] arr, final int lo,
                          final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
        }
    }

    /**
     * time complexity of this method is O(1).
     * Swap the elements.
     *
     * @param      arr  The arguments
     * @param      j  The arguments
     * @param      min  The arguments
     */
    public void exch(final Comparable[] arr, final int j, final int min) {
        Comparable temp = arr[j];
        arr[j] = arr[min];
        arr[min] = temp;
    }

    /**
     * Returns a string representation of the object.
     *
     * @param      arr   The arr
     *
     * @return     String representation of the object.
     * time complexity of this method is O(N).
     */
    public String toString(final Comparable[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[arr.length - 1] + "]";
        return str;
    }
    /**
     * sort the sub arrays.
     *
     * @param      arr  The array
     * @param      low  lowest index
     * @param      high  highest index
     * @param      cutOff  index
     * time complexity is O(Nlog N)
     */
    public void sort(final Comparable[] arr, final int low,
                     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(arr, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(arr, low, high);
        System.out.println(toString(arr));
        sort(arr, low, k - 1, cutOff);
        sort(arr, k + 1, high, cutOff);
    }
    //time complexity is O(1)
    /**
     * sort method.
     *
     * @param      array   The array
     * @param      cutOff  The cut off
     * time complexity is O(Nlog N)
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }

    /**
     * Method to partition elements of the array.
     * @param      arr   The arr
     * @param      low   The low
     * @param      high  The high
     *
     * @return     integer
     * time complexity is O(N)
     */
    public int partition(final Comparable[] arr,
                         final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, low, j);
        return j;
    }

    /**
     * to compare two elements.
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return    true or false
     * time complexity is O(1)
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}
