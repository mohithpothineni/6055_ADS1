/**
 * Class for sequential search st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class SequentialSearchST<Key, Value> {
    /**
     * number of key-value pairs.
     */
    private int n;
    /**
     * the linked list of key-value pairs.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * key of type String.
         */
        private Key key;
        /**
         * val of type Integer.
         */
        private Value val;
        /**
         * next of type Node.
         */
        private Node next;
        /**
         * Constructs the object.
         * @param      key1   The key
         * @param      val1   The value
         * @param      next1  The next
         */
        Node(final Key key1, final Value val1, final Node next1)  {
            key  = key1;
            val  = val1;
            next = next1;
        }
    }
    /**
     * Checks whether the key is present in the symbol table or not.
     * @param      key   The key
     * @return     true or false.
     * Time complexity for this method is O(1).
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * gets the value of the particular key in the symbol table.
     * @param      key   The key
     * @return     Value of type Integer.
     * Time complexity for this method is O(N).
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }
    /**
     * inserts key value pair into the symbol table.
     * @param      key   The key
     * @param      val   The value
     * Time complexity for this method is O(N).
     */
    public void put(final Key key, final Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
}
