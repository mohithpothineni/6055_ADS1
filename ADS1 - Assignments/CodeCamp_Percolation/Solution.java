import java.util.Scanner;

/**
 * Interface for percolation.
 * defines the methods necessary for implementation of perculation concept.
 */
interface PercolationAPI {

    /**
     * open site (row, col) if it is not open already.
     *
     * @param      row   The row index.
     * @param      col   The col index.
     */
    void open(int row, int col);


    /**
     * Determines if site is open or not.
     *
     * @param      row   The row index
     * @param      col   The col index
     *
     * @return     True if open, False otherwise.
     */
    boolean isOpen(int row, int col);


    /**
     * does the system percolate?.
     *
     * @return     true if precolation can be done else false.
     */
    boolean percolates();
}

/**
 * Class for percolation.
 */
class Percolation implements PercolationAPI {
    /**
     * matrix array of type boolean which stores the open and closed sites.
     */
    private boolean[][] matrix;
    /**
     * Virtual node top for top rows.
     */
    private int top = 0;
    /**
     * Virtual node bottom for bottom rows.
     */
    private int bottom;
    /**
     * size variable to keep track of the size of matrix.
     */
    private int size;
    /**
     * qf which is the object of WeightedQuickUnionUF class.
     */
    private WeightedQuickUnionUF qf;
    /**
     * Constructs the object.
     * @param      n     number of nodes.
     */
    Percolation(final int n) {
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        matrix = new boolean[size][size];
    }

    /**
     * Open method to connect the nodes.
     * @param      row   The row index.
     * @param      col   The col index.
     */
    public void open(final int row, final int col) {
        matrix[row - 1][col - 1] = true;
        if (row == 1) {
            qf.union(getQFIndex(row, col), top);
        }
        
        if (row == size) {
            qf.union(getQFIndex(row, col), bottom);
        }
        
        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getQFIndex(row, col), getQFIndex(row, col - 1));
        }
        
        if (col < size && isOpen(row, col + 1)) {
            qf.union(getQFIndex(row, col), getQFIndex(row, col + 1));
        }
        
        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getQFIndex(row, col), getQFIndex(row - 1, col));
        }
        
        if (row < size && isOpen(row + 1, col)) {
            qf.union(getQFIndex(row, col), getQFIndex(row + 1, col));
        }
    }
    
    /**
     * Determines if open.
     * @param      row   The row
     * @param      col   The col
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        return matrix[row - 1][col - 1];
    }
    
    /**
     * Percolates method to find whether the matrix percolates or not.
     * @return     True if percolates, False otherwise.
     */
    public boolean percolates() {
        return qf.connected(top, bottom);
    }
    
    /**
     * Gets the qf index.
     * @param      row   The row index.
     * @param      col   The col index.
     * @return     The qf index.
     */
    public int getQFIndex(final int row, final int col) {
        return size * (row - 1) + col;
    }
}

/**
 * Class for weighted quick union uf.
 */
class WeightedQuickUnionUF {
    /**
     * Parent array.
     */
    private int[] parent;
    /**
     * size array.
     */
    private int[] size;
    /**
     * count variable to keep track of the count.
     */
    private int count;
    /**
     * Constructs the object.
     * @param      n     no of nodes.
     */
    WeightedQuickUnionUF(final int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    /**
     * count method to return the count.
     * @return     count.
     */
    public int count() {
        return count;
    }
    /**
     * finds the root of the given node.
     * @param      p     node.
     * @return     root of the node.
     */
    public int find(final int p) {
        int p1 = p;
        validate(p1);
        while (p1 != parent[p1]) {
            p1 = parent[p1];
        }
        return p1;
    }
    /**
     * validate method.
     * @param      p     node.
     */
    private void validate(final int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p
                   + " is not between 0 and " + (n - 1));
        }
    }
    /**
     * checks whether the nodes are connected or not.
     * @param      p     first node.
     * @param      q     second node.
     * @return     True if both nodes have same root, False
     *             otherwise.
     */
    public boolean connected(final int p, final int q) {
        return find(p) == find(q);
    }
    /**
     * Union method to find the union between the nodes.
     * @param      p     first node.
     * @param      q     second node.
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
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
     * main method which takes the input and checks
       whether it is percolating or not.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noofnodes = Integer.parseInt(sc.nextLine());
        Percolation p = new Percolation(noofnodes);
        String[] tokens = new String[2];
        while (sc.hasNext()) {
            String line = sc.nextLine();
            tokens = line.split(" ");
            p.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        System.out.println(p.percolates());
    }
}
