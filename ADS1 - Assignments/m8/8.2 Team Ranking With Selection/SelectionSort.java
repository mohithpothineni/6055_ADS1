import java.util.Arrays;
/**
 * Class for selection sort.
 */
public final class SelectionSort {

    /**
     * Constructs the object.
     */
    private SelectionSort() {

    }

    /**
     * swaps the element in the array.
     *
     * @param      teams  The teams
     * @param      i      ith index
     * @param      j      jth index
     */
    public static void exch(CricketTeam[] teams, final int i, final int j) {
        CricketTeam ct = teams[j];
        teams[j] = teams[i];
        teams[i] = ct;
    }

    /**
     * comparion between teams by calling compareTO.
     *
     * @param      array   The cricket teams list.
     * @param      i       ith index
     * @param      j       jth index
     *
     * @return     int flag of the comparision.
     * 
     * Time complexity : O(1)
     * it takes constant time for comparision.
     */
    public static boolean less(CricketTeam[] array,
        final int i, final int j) {
        return  array[i].compareTo(array[j]) > 0;
    }

    /**
     * selection sort implementation.
     *
     * @param      teamss  The teamss to be analyzed.
     *
     * @return     sorted cricket teams in the array.
     * 
     * Time complexity : O(n ^^ 2)
     * 
     * iterating over main array and also sub array combinedly gives
     * the complexity of n raised to power n.
     */
    public static CricketTeam[] selectionSort(final CricketTeam[] teamss) {
        
        CricketTeam[] teams = new CricketTeam[teamss.length];

        for (int i = 0; i < teamss.length; i++) {
            teams[i] = teamss[i];
        }


        for (int i = 0; i < teams.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < teams.length; j++) {
                try {
                    if (less(teams, j, min)) {
                    min = j;
                    }    
                } catch (Exception e) {

                }
                
            }
            exch(teams, i, min);
        }

        return teams;
    }

}
