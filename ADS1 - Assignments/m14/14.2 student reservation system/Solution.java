import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * name of student.
     */
    private String name;

    /**
     * date of birth.
     */
    private String dob;

    /**
     * marks of sub1.
     */
    private int subject1;

    /**
     * marks of sub2.
     */
    private int subject2;

    /**
     * marks of sub3.
     */
    private int subject3;

    /**
     * total marks.
     */
    private int totalMarks;
    /**
     * categeory to which they belong.
     */
    private String categeory;

    /**
     * getter for categeory.
     *
     *Time complexity : O(1)
     *
     * @return     categeory of student.
     */
    String categeory() {
        return this.categeory;
    }


    /**
     * Constructs the object.
     *
     * @param      namee    The namee
     * @param      dobirth  The dobirth
     * @param      sub1     The sub 1
     * @param      sub2     The sub 2
     * @param      sub3     The sub 3
     * @param      totalm   The totalm
     * @param      categry  The categry
     */
    Student(final String namee, final String dobirth,
        final int sub1, final int sub2,
        final int sub3,
        final int totalm,
        final String categry) {
        this.name = namee;
        this.dob = dobirth;
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
        this.totalMarks = totalm;
        this.categeory = categry;
    }

    /**
     * description for comparision.
     *
     * @param      other  The other object.
     *
     * @return     comparision flag.
     *
     * Time complexity : O(1)
     * as it requires constant time for comparision.
     *
     */
    public int compareTo(final Student other) {
        if (this.totalMarks > other.totalMarks) {
            return -1;
        } else if (this.totalMarks == other.totalMarks) {
            if (this.subject3 > other.subject3) {
                return -1;
            } else if (this.subject3 == other.subject3) {
                if (this.subject2 > other.subject2) {
                    return -1;
                } else if (this.subject2 == other.subject2) {
                    String[] t1 = this.dob.split("-");
                    String[] t2 = other.dob.split("-");


                    Integer year1 = Integer.parseInt(t1[2]);
                    Integer year2 = Integer.parseInt(t2[2]);

                    Integer month1 = Integer.parseInt(t1[1]);
                    Integer month2 = Integer.parseInt(t2[1]);

                    Integer day1 = Integer.parseInt(t1[0]);
                    Integer day2 = Integer.parseInt(t2[0]);

                    if (year1.compareTo(year2) != 0) {
                        return year2.compareTo(year1);
                    } else {
                        if (month1.compareTo(month2) != 0) {
                            return month2.compareTo(month1);
                        } else {
                            return day2.compareTo(day1);
                        }
                    }
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name + "," + this.totalMarks + "," + this.categeory;
    }


}

/**
 * Class for students data.
 */
class StudentsData {
    /**
     * students array.
     */
    private Student[] students;

    /**
     * size of students array.
     */
    private int size = 0;
    /**
     * alloted students list size.
     */
    private int size2 = 0;

    /**
     * no of vacancies.
     */
    private int vacancies;
    /**
     *no of unreserved seats.
     */
    private int unreserved;

    /**
     * no of reserved seats.
     */
    private int reserved;

    /**
     * bc count.
     */
    private int bccount;

    /**
     * sc count.
     */
    private int sccount;

    /**
     * st count.
     */
    private int stcount;

    /**
     * alloted students array.
     */
    private Student[] allotStudents;

    /**
     * Constructs the object.
     *
     * @param      noOfStudents    No of students
     * @param      noOfvacancy     No ofvacancy
     * @param      noOfunreserved  No ofunreserved
     * @param      noOfreserved    No ofreserved
     * @param      bccountt        The bccountt
     * @param      sccountt        The sccountt
     * @param      stcountt        The stcountt
     */
    StudentsData(final int noOfStudents, final int noOfvacancy,
                 final int noOfunreserved,
                 final int noOfreserved,
                 final int bccountt,
                 final int sccountt,
                 final int stcountt) {
        this.students = new Student[noOfStudents];
        this.vacancies = noOfvacancy;
        this.unreserved = noOfunreserved;
        this.reserved = noOfreserved;
        this.allotStudents = new Student[noOfvacancy];
        this.bccount = bccountt;
        this.sccount = sccountt;
        this.stcount = stcountt;
    }

    /**
     * Adds a student.
     *
     *Time complexity : O(1)
     * @param      studentt  The studentt
     */
    void addStudent(final Student studentt) {
        students[size++] = studentt;
    }

    /**
     * Shows the merit list.
     * Time complexity : O(n)
     * n iterations.
     */
    void showMeritList() {
        this.sort();

        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    /**
     * sorts ther data.
     * Time complexity : O(nlogn)
     * using merge sort internally.
     */
    void sort() {
        Arrays.sort(this.students);
    }

    /**
     * Determines if the obj in the alloted list.
     *
     *Time complexity : O(n)
     *n iterations
     * @param      obj   The object
     *
     * @return     True if in, False otherwise.
     */
    boolean isIn(final Student obj) {
        for (Student stu : allotStudents) {
            if (stu != null && stu.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Shows the alloted students.
     * Time complexity : O(n)
     * searching and assigning.
     */
    void showAlloted() {
        //merits irrespective of categeory
        for (int i = 0; i < this.unreserved; i++) {
            this.allotStudents[this.size2++] = this.students[i];
        }

        //bc search
        int bccountflag = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].categeory().equals("BC")
                && bccountflag != this.bccount && !isIn(this.students[i])) {
                this.allotStudents[this.size2++] = this.students[i];
                bccountflag++;
            }
            if (bccountflag == this.bccount) {
                break;
            }
        }




        //sc search
        int sccountflag = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].categeory().equals("SC")
                && sccountflag != this.sccount && !isIn(this.students[i])) {
                this.allotStudents[this.size2++] = this.students[i];
                sccountflag++;
            }
            if (sccountflag == this.sccount) {
                break;
            }
        }



        //st search
        int stcountflag = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].categeory().equals("ST")
                && stcountflag != this.stcount && !isIn(this.students[i])) {
                this.allotStudents[this.size2++] = this.students[i];
                stcountflag++;

            }
            if (stcountflag == this.stcount) {
                break;
            }
        }

        if (sccountflag != this.sccount) {
            for (int i = 0; i < this.students.length; i++) {
                if (sccountflag != this.sccount && !isIn(this.students[i])) {
                    this.allotStudents[this.size2++] = this.students[i];
                    sccountflag++;
                }
                if (sccountflag == this.sccount) {
                    break;
                }
            }
        }

        if (stcountflag != this.stcount) {
            for (int i = 0; i < this.students.length; i++) {
                if (stcountflag != this.stcount && !isIn(this.students[i])) {
                    this.allotStudents[this.size2++] = this.students[i];
                    stcountflag++;

                }
                if (stcountflag == this.stcount) {
                    break;
                }
            }
        }

        if (bccountflag != this.bccount) {
            for (int i = 0; i < this.students.length; i++) {
                if (bccountflag != this.bccount && !isIn(this.students[i])) {
                    this.allotStudents[this.size2++] = this.students[i];
                    bccountflag++;
                }
                if (bccountflag == this.bccount) {
                    break;
                }
            }
        }
        Arrays.sort(this.allotStudents);
        for (Student stu : this.allotStudents) {
            System.out.println(stu);
        }



    }


}

/**
 * class for Solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main fun reads input from user,
     * calls the appropriate func,
     * prints the output.
     *
     *Time complexity : O(N)
     *need to read n number of inputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int qualified = scan.nextInt();
        int vacancy = scan.nextInt();
        int unreserved = scan.nextInt();
        int bcNo = scan.nextInt();
        int scNo = scan.nextInt();
        int stNo = scan.nextInt();

        StudentsData data = new StudentsData(qualified,
            vacancy, unreserved, vacancy - unreserved, bcNo, scNo, stNo);

        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            final int three = 3;
            final int four = 4;
            final int five = 5;
            final int six = 6;

            try {
                data.addStudent(new Student(tokens[0],
                tokens[1], Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[three]),
                Integer.parseInt(tokens[four]),
                Integer.parseInt(tokens[five]), tokens[six]));
            } catch (Exception e) {
                //empty tokens array due to input glitch.
            }

        }

        data.showMeritList();
        System.out.println();
        data.showAlloted();
    }

}

