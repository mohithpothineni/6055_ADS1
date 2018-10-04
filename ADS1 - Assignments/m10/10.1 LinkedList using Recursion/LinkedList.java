/**
 * List of elements.
 *
 * @param   <E>   generic type.
 */
public class LinkedList<E> {

    /**
     * Class for node.
     *
     * @param      <E>   generic type of E.
     */
    public class Node<E> {
        /**
         * data in the node object.
         */
        private E data;

        /**
         * reference to next element.
         */
        private Node<E> next;
    }

    /**
     * start node of the list.
     */
    private Node<E> head = null;

    /**
     * end node in the list.
     */
    private Node<E> tail = null;

    /**
     * size of the list.
     */
    private int size = 0;

    /**
     * insertion through recursion.
     *
     * @param      start      The start
     * @param      position   The position
     * @param      reference  The reference
     *
     * @return     the element found that is to be added with new element.
     *
     * Time complexity : O(n)
     * as it iterates over the list to find the prev element.
     */
    Node<E> insertHelper(final int start, final int position,
                         final Node<E> reference) {
        if (start >= position) {
            return reference;
        }

        //at start
        if (position == 0) {
            return reference;
        }

        Node<E> referencee = reference.next;
        int startt = start + 1;

        return insertHelper(startt, position, referencee);
    }

    /**
     * insert an element at a position.
     *
     * @param      data      The data.
     * @param      position  The position.
     *
     * Time complexity : O(n)
     * as it searches for an element over the list.
     */
    void insert(final int position, final E data) {
        if (position > size || position < 0) {
            System.out.println("Can't insert at this position.");
            return;
        }

        Node<E> reference = head;

        //recursively search for elemet to which
        //new element to be added.
        reference = this.insertHelper(1, position, reference);

        Node<E> tmp = new Node<E>();
        tmp.data = data;
        if (reference == null) {
            head = tmp;
        } else if (position == 0) {
            tmp.next = head;
            head = tmp;
        } else {
            tmp.next = reference.next;
            reference.next = tmp;

        }

        size++;
        this.print();


    }


    /**
     * reverse through recusion.
     *
     * @return     reversed list chain.
     *
     * Time complexity : O(nlogn)
     *
     * as it deletes the last element using removeAtEnd
     * as the size decreases the iterations also decrease.
     *
     */
    Node<E> reverseHelper() {
        int tmp = this.size;

        if (this.size == 0) {
            return null;
        }

        if (this.size == 1) {
            return this.head;
        }

        if (this.size == 2) {
            Node<E> t = new Node<E>();
            t.data =  this.removeAtEnd();
            this.tail = new Node<E>();
            tail.data = this.removeAtEnd();
            tail.next = null;
            t.next = this.tail;

            return t;
        }

        Node<E> t = new Node<E>();
        t.data =  this.removeAtEnd();
        t.next = this.reverseHelper();
        this.size = tmp;
        return t;
    }

    /**
     * reverse the current head tail link.
     *
     * Time complexity : O(n)
     * as it iterates over the element by using reverseHelper.
     *
     */
    void reverse() {
        if (this.size == 0) {
            System.out.println("No elements to reverse.");
            return;
        }
        //recursively rearranges the list chain in reverse order.
        this.head = this.reverseHelper();
        this.print();
    }


    /**
     * remove element from list at a position.
     *
     * @param      position  The position
     *
     * @return     the element removed.
     *
     * Time complexity : O(1) when removed at start
     * Time complexity : O(n) when removed at a position
     *
     * constant time as there is no requirement fro iteration
     *
     * O(n) when it needs iteration.
     *
     */
    E remove(final int position) {
        if (position > size || head == null || position < 0) {
            return null;
        }

        //start position
        //handles only one element present in list
        //and also with n elemnts present.
        if (position == 0) {
            E element = head.data;
            try {
                head = head.next;
            } catch (Exception e) {
                head = null;
            }
            size--;
            return element;
        }

        //normal cases and last position.
        //System.out.println("being called,size is "+this.size);
        Node<E> reference = this.head;
        for (int i = 1; i < position; i++) {
            reference = reference.next;
        }

        E element = null;
        if (this.size != 1) {
            element = reference.next.data;
            reference.next = reference.next.next;
            if (reference.next == null) {
                this.tail = reference;
            }
        } else if (this.size == 1) {
            element = this.head.data;
            this.head = null;
        }
        size--;
        return element;
    }

    /**
     * Removes an element at end.
     *
     * @return     the element removed.
     *
     * Time complexity : O(n)
     * need to iterate from head to tail.
     */
    E removeAtEnd() {
        return this.remove(this.size - 1);
    }


    /**
     * prints the elements in the list.
     *
     * Time complexity : O(n)
     * it iterates over the list of n elements.
     */
    void print() {
        Node<E> reference = this.head;
        while (reference != null) {
            if (reference.next != null) {
                System.out.print(reference.data + ", ");
            } else {
                System.out.println(reference.data);
            }
            reference = reference.next;
        }
    }


}

