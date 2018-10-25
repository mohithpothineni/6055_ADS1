import java.util.Hashtable;
import java.util.Scanner;

/**
 * Class for ransom note.
 */
class RansomNote {

    /**
     * contents of magazine.
     */
    private String[] magazine;

    /**
     * contents of note.
     */
    private String[] note;


    /**
     * Constructs the object.
     *
     * @param      magazinee  The magazine content
     * @param      notee      The note content
     */
    RansomNote(final String[] magazinee, final String[] notee) {
        this.magazine = magazinee;
        this.note = notee;
    }

    /**
     * Determines ability to replicate.
     *
     * @return     True if able to replicate, False otherwise.
     *
     * Time complexity O(N)
     * Need to go through all the inputs to
     * declare it as replicable or not.
     */
    boolean canReplicate() {
        Hashtable<String, Integer> magazineContent
            = new Hashtable<String, Integer>();
        Hashtable<String, Integer> noteContent
            = new Hashtable<String, Integer>();

        for (String i : this.magazine) {
            if (magazineContent.containsKey(i)) {
                magazineContent.put(i, magazineContent.get(i) + 1);
            } else {
                magazineContent.put(i, 1);
            }
        }

        for (String j : this.note) {
            if (!magazineContent.containsKey(j)) {
                return false;
            }

            if (noteContent.containsKey(j)) {
                int t = noteContent.get(j) + 1;
                if (t > magazineContent.get(j)) {
                    return false;
                }
                noteContent.put(j, t);
            } else {
                noteContent.put(j, 1);
            }
        }

        return true;
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
     * main function takes input from user.
     * calls appropriate func
     * displays output on console.
     *
     * @param      args  The arguments
     * Time complexity O(N)
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lines = scan.nextLine().split(" ");

        String[] magazine = new String[Integer.parseInt(lines[0])];
        String[] note = new String[Integer.parseInt(lines[1])];

        for (int i = 0; i < magazine.length; i++) {
            magazine[i] = scan.next();
        }

        for (int i = 0; i < note.length; i++) {
            note[i] = scan.next();
        }

        RansomNote rn = new RansomNote(magazine, note);
        if (rn.canReplicate()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }


}
