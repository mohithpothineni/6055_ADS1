import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is N(while loop)
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort sort = new Sort();
        int input = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < input; i++) {
            int j = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                sort.sort(tokens, j);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}
