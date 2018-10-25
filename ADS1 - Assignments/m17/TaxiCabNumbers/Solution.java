
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
     * main method takes input from user.
     * calls the specific func and
     * prints the output.
     *
     * @param      args  The commandline arguments
     *
     * Time complexity : O(n)
     * n inputs from user.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");

        final int n = 600;

        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }

        // find smallest sum, print it out, and update
        int previous = -1;
        int count = 0;
        int required = Integer.parseInt(tokens[0]);
        int conscount  = 0;
        int reqconscount = Integer.parseInt(tokens[1]) - 1;

        while (true) {
            CubeSum s = pq.delMin();
            if (s.sum == previous) {
                conscount++;
            } else {
                previous = s.sum;
                conscount = 0;
            }

            if (conscount == reqconscount) {
                count++;
            }

            if (count == required) {
                System.out.println(s.sum);
                break;
            }

            if (s.j < n) {
                pq.insert(new CubeSum(s.i, s.j + 1));
            }
        }
    }
}


