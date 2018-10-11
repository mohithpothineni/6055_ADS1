import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * book name.
     */
    private String name;
    /**
     * author name.
     */
    private String author;
    /**
     * price of the book.
     */
    private double price;
    /**
     * Constructs the object.
     */
    Book() {
    }
    /**
     * Constructs the object.
     *
     * @param      n    The name
     * @param      au  The author
     * @param      pr   The price
     */
    Book(final String n, final String au, final double pr) {
        this.name = n;
        this.author = au;
        this.price = pr;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public double getPrice() {
        return price;
    }
    /**
     * Method to compare.
     *
     * @param      that  The that
     *
     * @return     integer value +1,-1,0
     */
    public int compareTo(final Book that) {
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for node.
 *
 */
class Node {
    /**
     * Book object.
     */
    private Book key;
    /**
     * value.
     */
    private String value;
    /**
     * left node, right node.
     */
    private Node left, right;
    /**
     * Constructs the object.
     *
     * @param      k    The key
     * @param      val  The value
     */
    Node(final Book k, final String val) {
        this.key = k;
        this.value = val;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public String getValue() {
        return value;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Sets the left.
     *
     * @param      l  The left
     */
    public void setLeft(final Node l) {
        this.left = l;
    }
    /**
     * Sets the right.
     *
     * @param      r  The right
     */
    public void setRight(final Node r) {
        this.right = r;
    }
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    public void setValue(final String val) {
        this.value = val;
    }
}

/**
 * Class for binary st.
 *
 */
class BinaryST {
    /**
     * Rot node.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinaryST() {
    }

    /**
     * Method to insert the key.
     *
     * @param      key    The key
     * @param      value  The value
     *
     * Time complexity : Log(N)
     * the insertion will be done based on trees.
     */
    public void put(final Book key, final String value) {
        root = put(root, key, value);
    }
    /**
     * Method to insert the keys.
     *
     * @param      x      The node.
     * @param      key    The key
     * @param      value  The value
     *
     * @return     The node.
     *
     * Time complexity : log(N)
     * recursively iterates over the tree.
     *
     */
    public Node put(final Node x, final Book key, final String value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.getName().compareTo(x.getKey().getName());
        if (cmp < 0) {
            x.setLeft(put(x.getLeft(), key, value));
        }
        if (cmp > 0) {
            x.setRight(put(x.getRight(), key, value));
        }
        if (cmp == 0) {
            x.setValue(value);
        }
        return x;
    }
    /**
     * Method to get value of the key.
     *
     * @param      key   The key
     *
     * @return     The value of the key
     *
     * Time complexity : Log(n)
     * Iteration over tree.
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.getKey().getName());
            if (cmp < 0) {
                x = x.getLeft();
            }
            if (cmp > 0) {
                x = x.getRight();
            }
            if (cmp == 0) {
                return x.getValue();
            }
        }
        return null;
    }

}

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
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryST bst = new BinaryST();
        final int three = 3;
        final int four = 4;
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] tokens = data.split(",");
            switch (tokens[0]) {
            case "put":
                Book book = new Book();
                book = new Book(tokens[1], tokens[2],
                                Double.parseDouble((tokens[three])));
                bst.put(book, tokens[four]);
                break;
            case "get":
                book = new Book(tokens[1], tokens[2],
                                Double.parseDouble(tokens[three]));
                System.out.println(bst.get(book));
                break;
            default:
                break;
            }
        }
    }
}
