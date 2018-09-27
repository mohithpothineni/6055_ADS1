import java.util.Arrays;

import java.util.Scanner;

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main method that prints the count of pairs.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        //sorting the array.
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                //using binary search for finding
                //the element.
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

