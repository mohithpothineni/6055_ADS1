import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for solution.
 */
public final class Solution {

  /**
   * Constructs the object.
   */
  private Solution() {

  }

  /**
   * main function takes input from user.
   * the array size,the array and the element to be searched.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner sc = new Scanner(System.in);
    int sizeOfArray = sc.nextInt();
    int[] array = new int[sizeOfArray];
    for (int i = 0; i < sizeOfArray; i++) {
      array[i] = sc.nextInt();
    }
    Arrays.sort(array);
    System.out.println(Arrays.toString(array));
    int search = sc.nextInt();
    System.out.println(binarySearch(array, 0, array.length - 1, search));
  }

  /**
   * binary search implementation using recursion.
   *
   * @param      array   The array
   * @param      start   The start
   * @param      end     The end
   * @param      search  The search
   *
   * @return     true if element found else false.
   */
  static boolean binarySearch(final int[] array,
    final int start, final int end, final int search) {
    if (end >= start) {
      int middleValue = start + (end - start) / 2;
      if (array[middleValue] == search) {
        return true;
      }
      if (array[middleValue] > search) {
        return binarySearch(array, start, middleValue - 1, search);
      }
      return binarySearch(array, middleValue + 1, end, search);
    }
    return false;
  }

}