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
     * gets input from user and calls the list func.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "insertAt":
                    list.insert(Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                    break;
                case "reverse":
                    list.reverse();
                    break;
                default:
                    break;
            }
        }
    }



}

