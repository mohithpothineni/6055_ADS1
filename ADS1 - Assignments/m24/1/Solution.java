import java.util.Scanner;

/**
 * Class for student.
 */
class Student {

    /**
     * roll call of student.
     */
    private int rollnumber;

    /**
     * name of student.
     */
    private String name;

    /**
     * marks of the student.
     */
    private double marks;

    /**
     * Gets the name of the student.
     *
     * @return     The name.
     *
     * Time complexity O(1).
     */
    String getName() {
        return this.name;
    }

    /**
     * Gets the marks of the student.
     *
     * @return     The marks.
     *
     * Time complexity O(1).
     */
    double getMarks() {
        return this.marks;
    }

    /**
     * Gets the roll number of the student.
     *
     * @return     The roll number.
     *
     * Time complexity O(1).
     */
    int getRollNum() {
        return this.rollnumber;
    }

    /**
     * Constructs the object.
     *
     * @param      rollcall  The rollcall of the student
     * @param      namee     The namee of the student
     * @param      mark      The mark of the student
     */
    Student(final int rollcall, final String namee, final double mark) {
        this.rollnumber = rollcall;
        this.name = namee;
        this.marks = mark;
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
     * main func gets input from user.
     * calls appropriate func
     * prints output to console.
     * Time complexity for this method is O(N log N)*
     * For some cases the time complexity may be O(M * N) where
     * M is for hash method and N is for while loop.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);

        //student data parsing and storing.
        LinearProbingHashST<Integer, Student> linearpst =
            new LinearProbingHashST();
        int numofstudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numofstudents; i++) {
            String[] tokens = scan.nextLine().split(",");
            Integer rollcall = Integer.parseInt(tokens[0]);
            linearpst.put(rollcall,
            new Student(rollcall, tokens[1], Double.parseDouble(tokens[2])));
        }

        //operations on ths data.
        int operations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < operations; i++) {
            String[] tokens = scan.nextLine().split(" ");

            switch (tokens[2]) {

            //for getting name.
            case "1":
                Student studentt = linearpst.get(Integer.parseInt(tokens[1]));
                if (studentt != null) {
                    System.out.println(studentt.getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
                break;

            //for getting marks.
            case "2":
                Student student = linearpst.get(Integer.parseInt(tokens[1]));
                if (student != null) {
                    System.out.println(student.getMarks());
                } else {
                    System.out.println("Student doesn't exists...");
                }
                break;
            default:
                break;
            }
        }



    }
}






