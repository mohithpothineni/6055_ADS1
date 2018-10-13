import java.util.Scanner;
import java.util.ArrayList;

final class Solution {
    
    private Solution() {

    }

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfStocks = scan.nextInt();
        final int hours = 6;
        

        //to eliminate errod due to int scan.
        scan.nextLine(); 
        
        //binary search symbol table
        BinarySearchST<String,  Integer> maxST = new BinarySearchST<String, Integer>(noOfStocks);
        BinarySearchST<String, Integer> minST = new BinarySearchST<String, Integer>(noOfStocks);

        for (int i = 0 ; i < hours; i++) {
            //create a min and max pq for every hour.
            MinPQ<Stock> minpq = new MinPQ<Stock>(noOfStocks);
            MaxPQ<Stock> maxpq = new MaxPQ<Stock>(noOfStocks);
            
            for (int j = 0; j < noOfStocks; j++) {
                String[] tokens = scan.nextLine().split(",");
                Stock stock = new Stock(tokens[0], Double.parseDouble(tokens[1]));
                minpq.insert(stock);
                maxpq.insert(stock);
            }
            
            //print 5 max stocks
            for (int k = 0 ; k < 5; k++) {
                Stock tmpp = maxpq.delMax();
                Integer f = maxST.get(tmpp.name);
                if (f != null) {
                    maxST.put(tmpp.name, f + 1);
                } else {
                    maxST.put(tmpp.name, 1);
                }
                System.out.println(tmpp);
            }
            System.out.println();
            //print 5 min stocks
            for (int k = 0 ; k < 5; k++) {
                Stock tmpp = minpq.delMin();
                Integer f = minST.get(tmpp.name);
                if (f != null) {
                    minST.put(tmpp.name, f + 1);
                } else {
                    minST.put(tmpp.name, 1);
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
                if(tokens[1].equals("minST")) {
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
            } else {

            }

        }

    }

}




class Stock implements Comparable<Stock>{

    String name;
    Double percentage;


    Stock(String namee, Double percent) {
        this.name = namee;
        this.percentage = percent;
    }


    public int compareTo(Stock other) {
        int temp = this.percentage.compareTo(other.percentage);
        if (temp != 0) {
            return temp;
        }

        return this.name.compareTo(other.name);
    }

    public String toString() {
        return this.name + " " + this.percentage;
    }


}
