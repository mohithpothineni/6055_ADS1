import java.util.Scanner;

/**
 * Class for steque.
 *
 * @param      <E>   generic E.
 */
class Steque<E> {

    /**
     * uses linkedList for implementing the steque concept.
     */
    private LinkedList<E> list = new LinkedList<E>();

    /**
     * adds the element at the start of steque.
     *
     * @param      data  The data
     *
     * Time complexity : O(1)
     *
     * The element will be directly added before the head element
     * becoming the head. so the time taken is constant.
     */
    void push(final E data) {
        list.insertAtStart(data);
        this.print();
    }


    /**
     * add element at end of steque.
     *
     *displays the steque elemnts.
     * @param      data  The data
     *
     * Time complexity : O(1)
     *
     * Using tail as reference to the last element,
     * the new element is directly added to the last element.
     * So the time taken is constant.
     */
    void enqueue(final E data) {
        list.insertAtEnd(data);
        this.print();
    }

    /**
     * pops the element from steque.
     * displays the steque form by calling print func.
     *
     * Time complexity : O(1)
     *
     * The element is removed by making the next node,
     * as the head so the previous is garbage collected.
     * So the time taken is constant.
     *
     */
    void pop() {
        list.removeAtStart();
        this.print();
    }

    /**
     * prints the elments of steque.
     *
     * Time complexity : O(n)
     *
     * The elemets are traversed from head to tail
     * so for n elements present in the list,
     * n number of iterations are made.
     * So the time compexity will be proportiante to n.
     *
     */
    void print() {
        if (this.list.size == 0) {
            System.out.println("Steque is empty.");
        } else {
            this.list.print();
        }
    }

}

/**
 * Solution class for running the program.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * this method takes input from user
     * and prints output from console.
     *
     * @param      args  The arguments
     *
     * Time complexity : O(n)
     *
     * for n number of test cases the program needs
     * to run for n times so time taken is proportional to n.
     *
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Steque<Integer> steque = new Steque<Integer>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("")) {
                steque = new Steque<Integer>();
            } else {
                switch (tokens[0]) {
                case "push":
                    steque.push(Integer.parseInt(tokens[1]));
                    break;
                case "enqueue":
                    steque.enqueue(Integer.parseInt(tokens[1]));
                    break;
                case "pop":
                    steque.pop();
                    break;
                default:
                    break;
                }
            }
        }

    }


}
