import java.util.Scanner;

/**
 * LinkedList implementaing Stack.
 *
 * @param      <T>   generic mode.
 */
class LinkedStack<T> {

    /**
     * generic type node.
     */
    private Node<T> first = null;

    /**
     * Class for node.
     *
     * @param      <T>   generic mode.
     */
    class Node<T> {
        /**
         * T data item.
         */
        private T item;

        /**
         * Node next.
         */
        private Node<T> next;

    }

    /**
     * check whether stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * push method is used to push the item.
     * @param item element to push.
     */
    public void push(final T item) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldfirst;
    }
    /**
     * pop method is to remove the item.
     * @return the poped element.
     */
    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

}

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
     * main func prints the solution.
     * by taking input from user.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfIterations = scan.nextInt();

        while (scan.hasNext()) {
            LinkedStack<Character> ll = new LinkedStack<Character>();
            String input = scan.next();
            boolean flag = false;
            if (input.charAt(0) == '}'
                    || input.charAt(0) == ']' || input.charAt(0) == ')') {
                System.out.println("NO");
            } else {
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) != '}' && input.charAt(i) != ']'
                            && input.charAt(i) != ')') {
                        ll.push(input.charAt(i));
                    } else if (!ll.isEmpty() && input.charAt(i) == '}') {
                        flag = (ll.pop() == '{');
                        if (!flag) {
                            break;
                        }
                    } else if (!ll.isEmpty() && input.charAt(i) == ']') {
                        flag = ll.pop() == '[';
                        if (!flag) {
                            break;
                        }
                    } else if (!ll.isEmpty() && input.charAt(i) == ')') {
                        flag = ll.pop() == '(';
                        if (!flag) {
                            break;
                        }
                    }

                }
                if (flag && ll.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }

    }


}
