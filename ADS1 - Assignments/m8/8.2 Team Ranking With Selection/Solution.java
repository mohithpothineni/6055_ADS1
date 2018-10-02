import java.util.Scanner;

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
     * main function.
     *
     * Time complexity O(n)
     * for n inputs the while loop runs n times
     * even though the combined input set is only one problem
     * the whileloop will call the teams object and add
     * to it the team created.
     *
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Teams cricketteams = new Teams();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] str = data.split(",");
            CricketTeam cric = new CricketTeam(str[0], str[1],
                                               str[2], str[2 + 1]);
            cricketteams.addCricketTeam(cric);
        }

        cricketteams.teams = SelectionSort.selectionSort(cricketteams.teams);

        System.out.println(cricketteams);
    }
}
