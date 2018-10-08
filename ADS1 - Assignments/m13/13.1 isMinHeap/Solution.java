import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Class for minimum heap.
 *
 * @param      <Key>  The key
 */
class MinHeap<Key extends Comparable<Key>> {

    /**
     * Array of key type.
     */
    private Key[] pq;

    /**
     * no of elements.
     */
    private int n = 0;

    /**
     * Constructs the object.
     */
    MinHeap() {
    }

    /**
     * COnstructs the object.
     *
     * @param      maxN  The maximum n
     */
    MinHeap(final int maxN) {

        /**
         * Initializing array.
         */
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /**
     * Constructs the object.
     *
     * @param      array  The array
     */
    MinHeap(final Comparable[] array) {

        /**
         * Initializing array.
         */
        this.pq = (Key[]) array;

        /**
         * initialzation of n.
         */
        this.n = array.length;
    }

    /**
     * Time complexity of this method is O(1).
     */
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * time complexity of size method is O(1).
     */
    /**
     * Method to find array size.
     *
     * @return     size
     */
    public int size() {
        return n;
    }

    /**
     * time complexity of less method is O(1).
     */
    /**
     * insert an element into the array.
     *
     * @param      v     The element
     */
    public void insert(final Key v) {
        pq[++n] = v;
    }

    /**
     * time complexity of less method is O(1).
     */
    /**
     * to compare two elements.
     *
     * @param      i     index i
     * @param      j     index j
     *
     * @return     true or false
     */
    public boolean less(final int i, final int j) {
        return pq[i].compareTo(pq[j]) >= 0;
    }

    /**
     * Time complexity of check method is log(N).
     */
    /**
     * checks if parent element is less than child element.
     *
     * @return     true or false
     */
    public boolean check() {
        int k = n - 1;
        while (k > 0) {
            if (!less(k, (k - 1) / 2)) {
                return false;
            }
            k--;
        }
        return true;
    }
}

/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Method for string parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeStringArray(final Scanner sc) {
        MinHeap<String> s = new MinHeap<String>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            s = new MinHeap(tokens);
            System.out.println(s.check());
        }
    }
    /**
     * Method for integer parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeIntegerArray(final Scanner sc) {
        MinHeap<Integer> s = new MinHeap<Integer>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Integer[] inp = new Integer[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Integer.parseInt(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
            }
    }
    /**
     * Method for double parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeDoubleArray(final Scanner sc) {
        MinHeap<Double> s = new MinHeap<Double>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Double[] inp = new Double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Double.parseDouble(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
        }
    }
    /**
     * Method for float parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeFloatArray(final Scanner sc) {
        MinHeap<Float> s = new MinHeap<Float>();
        int noOflines = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (sc.hasNext()) {
            count++;
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Float[] inp = new Float[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Float.parseFloat(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
        }
        if (count != noOflines) {
            System.out.println(false);
        }
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String objectType = sc.nextLine();
        switch (objectType) {
            case "String":
            executeStringArray(sc);
            break;
            case "Integer":
            executeIntegerArray(sc);
            break;
            case "Double":
            executeDoubleArray(sc);
            break;
            case "Float":
            executeFloatArray(sc);
            break;
            default:
            break;
        }
    }
}
