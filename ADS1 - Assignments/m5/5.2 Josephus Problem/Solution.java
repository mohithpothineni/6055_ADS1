import java.util.Scanner;

/**
 * NQueue class implements queue funtions.
 * It contain enqueue and dequeue methods.
 */
class NQueue {
    /**
     * head Node to point first element.
     */
    private Node head = null;
    /**
     * tail Node to point last element.
     */
    private Node tail = null;
    /**
     * current Node to point current element.
     */
    private Node current = null;
    /**
     * It contains data and node of next element.
     */
    class Node {
        /**
         * data variable to Store data.
         */
        private int data;
        /**
         * next is Node vatiable has next Node.
         */
        private Node next;
    }
    /**
     * Time complexity is O(1).
     * checks whether queue is empty or Not.
     * @return true are flase.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Time complexity is O(1).
     * enqueue method to enter into queue.
     * @param element which is to be entered in the queue.
     */
    public void enqueue(final int element) {
        if (head == null) {
            head = new Node();
            tail = new Node();
            head.data = element;
            tail = head;
            return;
        }
        current = new Node();
        current.data = element;
        tail.next = current;
        tail = current;
    }

    /**
     * Time complexity is O(1).
     * dequeue method to delete.
     * @return the element that is deleted.
     */
    public int dequeue() {
        Node temp = new Node();
        if (head == tail) {
            temp = head;
            head = null;
            tail = null;
            return temp.data;
         }
         temp = head;
         head = head.next;
         return temp.data;
    }
}

/**
 * Solution class contain main method.
 */
public final class Solution {
    /**
     * default Solution constructor.
     */
    private Solution() {

    }
    /**
     * main class to handle input and output.
     *
     * @param args commandline arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (scan.hasNext()) {
            NQueue n = new NQueue();
            int count = scan.nextInt();
            int cut = scan.nextInt();

            for (int i = 0; i < count; i++) {
                n.enqueue(i);
            }

            String result = "";
            while (!n.isEmpty()) {
                int t2 = 0, t1 = 0;
                for (int i = 0; i < cut; i++) {
                    if (i != cut - 1) {
                        t1 = n.dequeue();
                        n.enqueue(t1);
                    } else {
                        t2 = n.dequeue();
                    }
                }
                result += t2 + " ";
            }
            System.out.println(result.trim());
        }
    }
}
