/**
 * Class for insertion sort.
 */
class InsertionSort {
   
   /**
    * swaps the elements in the array.
    *
    * @param      teams  The teams array.
    * @param      i      ith index
    * @param      j      jth index
    */
    public static void exch(CricketTeam[] teams, int i, int j) {
        CricketTeam ct = teams[j];
        teams[j] = teams[i];
        teams[i] = ct; 
    }

    /**
     * compares which object is less.
     *
     * @param      arr   The array of teams.
     * @param      i     ith index
     * @param      j     jth index
     *
     * @return     int flag to make swaps.
     * 
     * Time complexity : O(1)
     * it takes constant time to compare.
     */
    public static boolean less(CricketTeam[] arr, int i, int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }

    /**
     * insertion sort.
     *
     * @param      array  The array to be sorted.
     *
     * @return     the sorted array.
     * 
     * Time complexity : O(n ^^ 2)
     * It takes two loops for forward and backward movement
     * for comparision and swapping inside the array
     * so the complexity will be equal to n raised to two. 
     */
    public static CricketTeam[] insertionSort(final CricketTeam[] array) {
        
        CricketTeam[] sortarr = new CricketTeam[array.length];

        for (int i = 0; i < sortarr.length; i++) {
            sortarr[i] = array[i];
        }

        for (int i = 0; i < sortarr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                try {
                    if (less(sortarr, j - 1, j)) {
                        exch(sortarr, j -1, j);
                    }    
                } catch (Exception e) {
               
               }  
            }
                
        }

        return sortarr;
    }
}