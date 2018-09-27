import java.util.Scanner;
import java.util.Arrays;


/**
 * Class for solution.
 */
public final class Solution {

    /**
     * constructs the object.
     */
    private Solution() {

    }

    /**
     * main prints the combined sorted elements.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {

        Scanner input = new Scanner(System.in);
        int arrayoOneSize = Integer.parseInt(input.nextLine());
        int arrayTwoSize = Integer.parseInt(input.nextLine());
        String[] arrayOneInput = input.nextLine().split(",");
        String[] arrayTwoInput = input.nextLine().split(",");
        int[] array1;
        int[] array2;
        array2 = new int[arrayTwoInput.length];

        if (arrayOneInput[0].equals("")) {
            array1 = new int[0];
        } else {
            array1 = new int[arrayOneInput.length];
            for (int i = 0; i < arrayOneInput.length; i++) {
                array1[i] = Integer.parseInt(arrayOneInput[i]);
            }
        }

        for (int i = 0; i < arrayTwoInput.length; i++) {
            array2[i] = Integer.parseInt(arrayTwoInput[i]);
        }

        sort(array1, array2);
    }

    /**
     * adds and print the lements in sorted manner.
     * of two sorted arrays.
     *
     * @param      array1  The array 1
     * @param      array2  The array 2
     */
    public static void sort(final int[] array1, final int[] array2) {
        int iIndex = 0;
        int jIndex = 0;
        int[] result;
        result = new int[array1.length + array2.length];
        for (int k = 0; k < result.length; k++) {
            if (iIndex < array1.length && jIndex < array2.length) {
                if (array1[iIndex] < array2[jIndex]) {
                    result[k] = array1[iIndex++];
                } else {
                    result[k] = array2[jIndex++];
                }
            } else if (iIndex >= array1.length) {
                result[k] = array2[jIndex++];
            } else if (jIndex >= array2.length) {
                result[k] = array1[iIndex++];
            }
        }
        System.out.println(Arrays.toString(result)
            .replace("[", "").replace("]", "").replace(" ", ""));

    }
}

