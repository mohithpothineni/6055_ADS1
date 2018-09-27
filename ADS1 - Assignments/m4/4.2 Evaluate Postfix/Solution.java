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
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main takes input from user and prints output to console.
     *
     * @param      args  The commandline arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        LinkedStack<Integer> ll = new LinkedStack<Integer>();
        for (int i = 0; i < s.length; i++) {
            try {
                ll.push(Integer.parseInt(s[i]));
            } catch (Exception e) {
                int t1 = ll.pop();
                int t2 = ll.pop();
                if (s[i].equals("*")) {
                    ll.push(t1 * t2);
                } else if (s[i].equals("+")) {
                    ll.push(t1 + t2);
                }
            }
        }
        System.out.println(ll.pop());
    }

}







