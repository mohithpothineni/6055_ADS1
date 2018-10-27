
import java.util.Scanner;

/**
 * Class for student.
 */
class Student implements Comparable<Student> {

    /**
     * roll call of student.
     */
    private Integer rollnumber;

    /**
     * name of student.
     */
    private String name;

    /**
     * marks of the student.
     */
    private Double marks;

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
    Double getMarks() {
        return this.marks;
    }

    /**
     * Gets the roll number of the student.
     *
     * @return     The roll number.
     *
     * Time complexity O(1).
     */
    Integer getRollNum() {
        return this.rollnumber;
    }


    /**
     * Constructs the object.
     *
     * @param      rollcall  The rollcall of the student
     * @param      namee     The namee of the student
     * @param      mark      The mark of the student
     */
    Student(final int rollcall, final String namee, final Double mark) {
        this.rollnumber = rollcall;
        this.name = namee;
        this.marks = mark;
    }

    /**
     * compares the Student object with
     * other student object and gives the
     * comparision flag.
     *
     * @param      other  The other
     *
     * @return     int comparision flag
     * Time complexity O(1).
     */
    public int compareTo(final Student other) {
        int tmp = this.getMarks().compareTo(other.getMarks());
        if (tmp != 0) {
            return tmp;
        } else {
            return this.getRollNum().compareTo(other.getRollNum());
        }

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
     * @param      args  The command line arguments
     *
     * Time complexity O(nLogn)
     * n inputs need to be add and put complexity is logn
     * get complexity is logn
     *
     *
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);

        //using redblack bst
        //complexity of rbbst for put logn
        //and for get logn.

        //student data parsing and storing.
        RedBlackBST<Student, String> studentdata =
            new RedBlackBST<Student, String>();
        int numofstudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numofstudents; i++) {
            String[] tokens = scan.nextLine().split(",");
            Integer rollcall = Integer.parseInt(tokens[0]);
            studentdata.put(new Student(rollcall, tokens[1],
                Double.parseDouble(tokens[2])), tokens[1]);
        }

        //for operations on student data.
        int numofoperations = Integer.parseInt(scan.nextLine());
        Student dummy1 = null;
        Student dummy2 = null;
        final double precission = 0.00005;
        for (int i = 0; i < numofoperations; i++) {
            String[] tokens = scan.nextLine().split(" ");

            switch (tokens[0]) {
            case "BE":
                dummy1 = new Student(-1, "dummy1",
                    Double.parseDouble(tokens[1]));
                dummy2 = new Student(-1, "dummy2",
                    (Double.parseDouble(tokens[2]) + precission));

                for (Student key : studentdata.keys(dummy1, dummy2)) {
                    System.out.println(key.getName());
                }
                break;
            case "LE":
                dummy1 = studentdata.min();
                dummy2 = new Student(-1, "dummy2",
                    (Double.parseDouble(tokens[1]) + precission));
                for (Student key : studentdata.keys(dummy1, dummy2)) {
                    System.out.println(key.getName());
                }
                break;
            case "GE":
                dummy2 = studentdata.max();
                dummy1 = new Student(-1, "dummy1",
                    Double.parseDouble(tokens[1]));
                for (Student key : studentdata.keys(dummy1, dummy2)) {
                    System.out.println(key.getName());
                }
                break;
            default:
                break;
            }
        }




    }
}






