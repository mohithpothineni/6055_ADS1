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
     * main method takes input from cli.
     * calls appropriate func.
     * prints output to console.
     *
     * @param      args  The command line arguments
     *
     * Time complexity : O(n)
     */
    public static void main(final String[] args) {

        final int three = 3;
        final int four = 4;

        Scanner scan = new Scanner(System.in);
        BST<Book, String> bst = new BST<Book, String>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new Book(tokens[1], tokens[2], tokens[three]),
                        tokens[four]);
                break;
            case "get":
                System.out.println(
                    bst.get(new Book(tokens[1], tokens[2], tokens[three])));
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                System.out.println(
                    bst.floor(new Book(tokens[1], tokens[2], tokens[three])));
                break;
            case "ceiling":
                System.out.println(
                    bst.ceiling(new Book(tokens[1], tokens[2], tokens[three])));
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "delete":
                Book bk4 = new Book(
                    tokens[1], tokens[2], tokens[three]);
                bst.delete(bk4);
                break;
            default:
                System.out.println("default call");
            }
        }
    }
}
