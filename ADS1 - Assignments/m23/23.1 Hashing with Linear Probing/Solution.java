import java.util.Scanner;
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
     * main method takes input from user.
     * calls appropriate func
     * display output to console
     * @param      args  The arguments
     * Time complexity for this method is O(N log N)*
     * For some cases the time complexity may be O(M * N) where
     * M is for hash method and N is for while loop.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinearProbingHashST<String, Integer> linearpst =
            new LinearProbingHashST();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
            case "put":
                linearpst.put(input[1], Integer.parseInt(input[2]));
                break;
            case "get":
                System.out.println(linearpst.get(input[1]));
                break;
            case "delete":
                linearpst.delete(input[1]);
                break;
            case "display":
                String str = "{";
                for (String s : linearpst.keys()) {
                    str += (s + ":" + linearpst.get(s) + ", ");
                }
                str = str.replaceAll(", $", "");
                System.out.println(str + "}");
                break;
            default:
                break;
            }
        }
    }
}
