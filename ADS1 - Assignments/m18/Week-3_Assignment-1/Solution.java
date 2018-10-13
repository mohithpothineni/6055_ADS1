import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {

    /**
     * name of the stock.
     */
    private String name;

    /**
     * getter for name.
     *
     * @return     name of stock.
     * 
     * Time complexity : O(1)
     * constant time.
     */
    String name() {
        return this.name;
    }

    /**
     * percentage of stock rate.
     */
    private Double percentage;

    /**
     * getter for percentage.
     *
     * @return     percentage of stock.
     *
     * Time complexity : O(1)
     * constant time.
     */
    Double percentage() {
        return this.percentage;
    }



    /**
     * Constructs the object.
     *
     * @param      namee    The namee
     * @param      percent  The percent
     */
    Stock(final String namee, final Double percent) {
        this.name = namee;
        this.percentage = percent;
    }

    /**
     * compares the object with other.
     *
     * @param      other  The other object
     *
     * @return     comparision int flag
     *
     * Time complexity : O(1)
     * constant time.
     */
    public int compareTo(final Stock other) {
        int temp = this.percentage.compareTo(other.percentage);
        if (temp != 0) {
            return temp;
        }

        return this.name.compareTo(other.name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     * 
     * Time complexity : O(1)
     * constant time.
     */
    public String toString() {
        return this.name + " " + this.percentage;
    }


}

/**
 * Solution class.
 */
final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main method takes input from user.
     * calls appropriate func
     * prints output to console.
     *
     * @param      args  The command line arguments
     * 
     * Time complexity : O(n)
     * 
     * based on no of inputs.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfStocks = scan.nextInt();
        final int hours = 6;
        final int limit = 5;

        //to eliminate errod due to int scan.
        scan.nextLine();

        //binary search symbol table
        BinarySearchST<String,  Integer> maxST =
        new BinarySearchST<String, Integer>(noOfStocks);
        BinarySearchST<String, Integer> minST =
        new BinarySearchST<String, Integer>(noOfStocks);

        for (int i = 0; i < hours; i++) {
            //create a min and max pq for every hour.
            MinPQ<Stock> minpq = new MinPQ<Stock>(noOfStocks);
            MaxPQ<Stock> maxpq = new MaxPQ<Stock>(noOfStocks);

            for (int j = 0; j < noOfStocks; j++) {
                String[] tokens = scan.nextLine().split(",");
                Stock stock = new Stock(tokens[0],
                    Double.parseDouble(tokens[1]));
                minpq.insert(stock);
                maxpq.insert(stock);
            }

            //print 5 max stocks
            for (int k = 0; k < limit; k++) {
                Stock tmpp = maxpq.delMax();
                Integer f = maxST.get(tmpp.name());
                if (f != null) {
                    maxST.put(tmpp.name(), f + 1);
                } else {
                    maxST.put(tmpp.name(), 1);
                }
                System.out.println(tmpp);
            }
            System.out.println();
            //print 5 min stocks
            for (int k = 0; k < limit; k++) {
                Stock tmpp = minpq.delMin();
                Integer f = minST.get(tmpp.name());
                if (f != null) {
                    minST.put(tmpp.name(), f + 1);
                } else {
                    minST.put(tmpp.name(), 1);
                }
                System.out.println(tmpp);
            }
            System.out.println();
        }

        int noOfQueries = scan.nextInt();
        if (noOfQueries == 0) {
            return;
        }

        scan.nextLine();

        for (int i = 0; i < noOfQueries; i++) {
            String[] tokens = scan.nextLine().split(",");
            if (tokens[0].equals("get")) {
                if (tokens[1].equals("minST")) {
                    Integer freq = minST.get(tokens[2]);
                    if (freq != null) {
                        System.out.println(freq);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    Integer freq = maxST.get(tokens[2]);
                    if (freq != null) {
                        System.out.println(freq);
                    } else {
                        System.out.println(0);
                    }
                }
            } else if (tokens[0].equals("intersection")) {
                ArrayList<String> keys = minST.keys();
                for (String key : keys) {
                    if (maxST.contains(key)) {
                        System.out.println(key);
                    }
                }
            }

        }

    }

}



