import java.util.Scanner;

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
     * gets user the user input and call the appropriate functions.
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        MergeSort m = new MergeSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            m.sort(tokens);
            System.out.println(m.print(tokens));
            System.out.println();
        }
    }
}
