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
        E data;

        /**
         * reference to next element.
         */
        Node<E> next;
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
    int size = 0;


    /**
     * insert an element at a position.
     *
     * @param      data      The data.
     * @param      position  The position.
     */
    void insert(final E data, final int position) {
        if (position > size) {
            return;
        }

        //at start
        if (position == 0) {
            //if head is null ie first addition.
            if (head == null) {
                head = new Node<E>();
                head.data = data;
                head.next = null;
                tail = head;
                size++;
            } else {
                //add before head element.
                Node<E> tmp = new Node<E>();
                tmp.data = data;
                tmp.next = head;
                head = tmp;
                size++;
            }
            

        } else if (position == size) {
            //at last.
            Node<E> tmp = new Node<E>();
            tmp.data = data;
            tail.next = tmp;
            tail = tmp;
            tail.next = null;
            size++;
        } else {
            Node<E> reference = head;
            for (int i = 1; i < position; i++) {
                reference = reference.next;
            }

            Node<E> tmp = new Node<E>();
            tmp.data = data;
            tmp.next = reference.next;
            reference.next = tmp;
            size++;
        }


    }

    /**
     * inserts an element at start.
     *
     * @param      data  The data to be added.
     */
    void insertAtEnd(final E data) {
        this.insert(data, this.size);
    }

    /**
     * insert an element at start of list.
     *
     * @param      data  The data to be added.
     */
    void insertAtStart(final E data) {
        this.insert(data, 0);
    }


    /**
     * remove element from list at a position.
     *
     * @param      position  The position
     *
     * @return     the element removed.
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
        Node<E> reference = this.head;
        for (int i = 1; i < position - 1; i++) {
            reference = reference.next;
        }

        E element = null;
        if (this.size != 1) {
            element = reference.next.data;
            reference.next = reference.next.next;
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
     */
    E removeAtEnd() {
        return this.remove(this.size);
    }

    /**
     * Removes an element at start.
     *
     * @return     the removed element from the list.
     */
    E removeAtStart() {
        return this.remove(0);
    }

    /**
     * prints the elements in the list.
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

