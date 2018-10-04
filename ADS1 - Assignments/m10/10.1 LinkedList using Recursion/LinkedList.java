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
     */
    Node<E> insertHelper(final int start, final int position,
        final Node<E> reference) {
        if (start >= position) {
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
     */
    void insert(final int position, final E data) {
        if (position > size || position < 0) {
            System.out.println("Can't insert at this position.");
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
            this.print();
            return;
        }



        Node<E> reference = head;
        //recursively search for elemet to which
        //new element to be added.
        reference = this.insertHelper(1, position, reference);
        Node<E> tmp = new Node<E>();
        tmp.data = data;
        tmp.next = reference.next;
        reference.next = tmp;
        size++;
        this.print();


    }

    /**
     * inserts an element at start.
     *
     * @param      data  The data to be added.
     */
    void insertAtEnd(final E data) {
        this.insert(this.size, data);
    }



    /**
     * reverse through recusion.
     *
     * @return     reversed list chain.
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
     * insert an element at start of list.
     *
     * @param      data  The data to be added.
     */
    void insertAtStart(final E data) {
        this.insert(0, data);
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
     */
    E removeAtEnd() {
        return this.remove(this.size - 1);
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

