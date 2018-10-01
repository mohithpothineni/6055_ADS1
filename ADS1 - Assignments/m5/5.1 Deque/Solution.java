import java.util.Scanner;

/**
 * Class for deque.
 * @param      <E>   E of type generic.
 */
class Deque<E> {
    /**
     * LinkedList class.
     */
    private LinkedList<E> list;
    /**
     * Constructs the object.
     */
    Deque() {
        this.list = new LinkedList<E>();
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return this.list.isEmpty();
    }
    /**
     * returns the size.
     * @return     size.
     */
    int size() {
        return this.list.getsize();
    }
    /**
     * Pushes at left.
     * @param      data  The data
     */
    void pushLeft(final E data) {
        this.list.insertAtStart(data);
    }
    /**
     * Pushes at right.
     * @param      data  The data
     */
    void pushRight(final E data) {
        this.list.insertAtEnd(data);
    }
    /**
     * pops the element to the left.
     */
    void popLeft() {
        this.list.deleteAtPos(1);
    }
    /**
     * pops the element to the right.
     */
    void popRight() {
        this.list.deleteAtPos(this.list.getsize());
    }
    /**
     * displays the queue.
     */
    void display() {
        this.list.display();
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
     * main method takes input from user and produces output.
     * @param      args  The commandline arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new Deque<Integer>();
        int n = Integer.parseInt(sc.nextLine());
        while (n != 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "isEmpty":
                System.out.println(deque.isEmpty());
                break;
            case "size":
                System.out.println(deque.size());
                break;
            case "pushLeft":
                deque.pushLeft(Integer.parseInt(tokens[1]));
                deque.display();
                break;
            case "pushRight":
                deque.pushRight(Integer.parseInt(tokens[1]));
                deque.display();
                break;
            case "popLeft":
                if (deque.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    deque.popLeft();
                    deque.display();
                }
                break;
            case "popRight":
                if (deque.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    deque.popRight();
                    deque.display();
                }
                break;
            default:
                break;
            }
            n--;
        }
    }
}
