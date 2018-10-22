import java.util.Scanner;


class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<Book,String> bst = new BST<Book,String>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                    bst.put(new Book(tokens[1],tokens[2],tokens[3]), tokens[4]);
                    break; 
                case "get":
                    System.out.println(bst.get(new Book(tokens[1],tokens[2],tokens[3])));
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
                    System.out.println(bst.floor(new Book(tokens[1],tokens[2],tokens[3])));
                    break;
                case "ceiling":
                    System.out.println(bst.ceiling(new Book(tokens[1],tokens[2],tokens[3])));
                    break;
                default:
                    System.out.println("default call");
            }
        }
    }
}