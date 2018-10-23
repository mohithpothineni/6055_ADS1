import java.util.ArrayDeque;
import java.util.NoSuchElementException;

/**
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class BST<Key extends Comparable<Key>, Value> {

    /**
     * root of BST.
     */
    private Node root;

    /**
     * Class for node.
     */
    private class Node {

        /**
         * sorted by key.
         */
        private Key key;

        /**
         * associated data.
         */
        private Value val;

        /**
         * left and right subtrees.
         */
        private Node left, right;

        /**
         * number of nodes in subtree.
         */
        private int size;

        /**
         * Constructs the object.
         *
         * @param      keyy   The key
         * @param      vall   The value
         * @param      sizee  The size
         */
        Node(final Key keyy, final Value vall, final int sizee) {
            this.key = keyy;
            this.val = vall;
            this.size = sizee;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true}
     * if this symbol table is empty; {@code false} otherwise
     * The time complexity is O(1).
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     * The time complexity is O(1).
     */
    public int size() {
        return size(root);
    }


    /**
     * return number of key-value pairs in BST rooted at x.
     *
     * @param      x     root element.
     *
     * @return     size of the tree.
     * The time complexity is O(1).
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * The time complexity is O(1).
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw
            new
            IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the
     * given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * The time complexity is O(N).
     */
    public Value get(final Key key) {
        return get(root, key);
    }

    /**
     * gives value corresponding to key.
     *
     * @param      x     root eleemnt.
     * @param      key   The key
     *
     * @return     value corresponding to key.
     * The time complexity is O(N).
     */
    private Value get(final Node x, final Key key) {
        if (key == null) {
            throw
            new
            IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    /**
     * Inserts the specified key-value pair
     * into the symbol table, overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key
     * (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * The time complexity is O(N).
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw
            new IllegalArgumentException("calls put() with a null key");
        }
        root = put(root, key, val);
    }

    /**
     * adds element to the tree.
     *
     * @param      x     root eleemnt.
     * @param      key   The key
     * @param      val   The value
     *
     * @return     Node element containing key and value.
     * The time complexity is O(N).
     */
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val   = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }




    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     * The time complexity is O(logN).
     */
    public Key min() {
        if (isEmpty()) {
            throw
            new
            NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    /**
     * gives minimum element of the tree.
     *
     * @param      x     root element.
     *
     * @return     minimum element in the tree.
     * The time complexity is O(logN).
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     * The time complexity is O(logN).
     */
    public Key max() {
        if (isEmpty()) {
            throw
            new
            NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    }

    /**
     * gives maximum element of a tree.
     *
     * @param      x     root element.
     *
     * @return     max element in the tree.
     * The time complexity is O(logN).
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    /**
     * Returns the largest key in the symbol
     * table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol
     * table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * The time complexity is O(logN).
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw
            new
            IllegalArgumentException("argument to floor() is null");
        }
        if (isEmpty()) {
            throw
            new
            NoSuchElementException("calls floor() with empty symbol table");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    /**
     * gives the floor of the element.
     *
     * @param      x     root element.
     * @param      key   The key
     *
     * @return     floor of the given element.
     * The time complexity is O(logN).
     */
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * public method for floor.
     *
     * @param      key   The key
     *
     * @return     floor eleemnt of given element.
     * The time complexity is O(logN).
     */
    public Key floor2(final Key key) {
        return floor2(root, key, null);
    }

    /**
     * gives the equal or less element from tree.
     *
     * @param      x     root element
     * @param      key   The key
     * @param      best  The best
     *
     * @return     floor of the given eleemnt.
     * The time complexity is O(logN).
     */
    private Key floor2(final Node x, final Key key, final Key best) {
        if (x == null) {
            return best;
        }
        int cmp = key.compareTo(x.key);
        if (cmp  < 0) {
            return floor2(x.left, key, best);
        } else if (cmp  > 0) {
            return floor2(x.right, key, x.key);
        } else {
            return x.key;
        }
    }

    /**
     * Returns the smallest key in the symbol
     * table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key
     * in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * The time complexity is O(logN).
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        if (isEmpty()) {
            throw
            new
            NoSuchElementException("calls ceiling() with empty symbol table");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    /**
     * presents the equal or greater element.
     * to the given element.
     *
     * @param      x     root element
     * @param      key   The key
     *
     * @return     the ceiling element
     * The time complexity is O(logN).
     */
    private Node ceiling(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and n
     * The time complexity is O(logN).
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw
            new
            IllegalArgumentException("argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }


    /**
     * Return key of rank k.
     *
     * @param      x     root element
     * @param      k     the index value.
     *
     * @return     element at the index.
     * The time complexity is O(logN).
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    /**
     * Return the number of keys in the symbol
     * table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol
     * table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * The time complexity is O(logN).
     */
    public int rank(final Key key) {
        if (key == null) {
            throw
            new IllegalArgumentException("argument to rank() is null");
        }
        return rank(key, root);
    }

    /**
     * Number of keys in the subtree less than key.
     *
     * @param      key   The key
     * @param      x     root node
     *
     * @return     rank of the given key.
     * The time complexity is O(logN).
     */
    private int rank(final Key key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     * The time complexity is O(logN).
     */
    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new ArrayDeque<Key>();
        }
        return keys(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     * The time complexity is O(logN).
     */
    public Iterable<Key> keys(final Key lo, final Key hi) {
        if (lo == null) {
            throw
            new IllegalArgumentException("first argument to keys() is null");
        }
        if (hi == null) {
            throw
            new IllegalArgumentException("second argument to keys() is null");
        }
        ArrayDeque<Key> queue = new ArrayDeque<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    /**
     * gives the keys of the tree.
     *
     * @param      x      root node.
     * @param      queue  The queue
     * @param      lo     The lower
     * @param      hi     The higher
     * The time complexity is O(logN).
     */
    private void keys(final Node x, final ArrayDeque<Key> queue,
                      final Key lo, final Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.add(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return the number of keys in the symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     * The time complexity is O(1).
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw
            new IllegalArgumentException("first argument to size() is null");
        }
        if (hi == null) {
            throw
            new IllegalArgumentException("second argument to size() is null");
        }
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

}

