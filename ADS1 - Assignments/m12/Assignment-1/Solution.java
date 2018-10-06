import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student>{
    String name;
    String dob;
    int subject1;
    int subject2;
    int subject3;
    int totalMarks;
    String categeory;

    Student(String namee, String dobirth, int sub1, int sub2, int sub3, int totalm, String categry) {
        this.name = namee;
        this.dob = dobirth;
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
        this.totalMarks = totalm;
        this.categeory = categry;
    }

    public int compareTo(Student other) {
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


    public String toString() {
        return this.name + "," + this.totalMarks + "," + this.categeory;
    }


}

class StudentsData {
    Student[] students;
    int size = 0;
    int size2 = 0;
    int vacancies;
    int unreserved;
    int reserved;
    int bccount;
    int sccount;
    int stcount;

    Student[] allotStudents;


    StudentsData(int noOfStudents, int noOfvacancy,
        int noOfunreserved, int noOfreserved, int bccountt, int sccountt, int stcountt) {
        this.students = new Student[noOfStudents];
        this.vacancies = noOfvacancy;
        this.unreserved = noOfunreserved;
        this.reserved = noOfreserved;
        this.allotStudents = new Student[noOfvacancy];
        this.bccount = bccountt;
        this.sccount = sccountt;
        this.stcount = stcountt;
    }

    void addStudent(Student studentt) {
        students[size++] = studentt;
    }

    void showMeritList() {
        this.sort();

        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    void sort() {
        Arrays.sort(this.students);
    }

    boolean isIn(Student obj) {
        for (Student stu : allotStudents) {
            if(stu != null && stu.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    void showAlloted() {
        //merits irrespective of categeory
        for (int i = 0; i < this.unreserved; i++) {
            this.allotStudents[this.size2++] = this.students[i];
        }

        //bc search
        int bccountflag = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].categeory.equals("BC") && bccountflag != this.bccount && !isIn(this.students[i])) {
                this.allotStudents[this.size2++] = this.students[i];
                bccountflag++;       
            }
            if (bccountflag == this.bccount) {
                break;
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

        
        //sc search
        int sccountflag = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].categeory.equals("SC") && sccountflag != this.sccount && !isIn(this.students[i])) {
                this.allotStudents[this.size2++] = this.students[i];
                sccountflag++;
            } 
            if (sccountflag == this.sccount) {
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

        //st search
        int stcountflag = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].categeory.equals("ST") && stcountflag != this.stcount && !isIn(this.students[i])) {
                this.allotStudents[this.size2++] = this.students[i];
                stcountflag++;
                       
            }
            if (stcountflag == this.stcount) {
                break;
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

        Arrays.sort(this.allotStudents);
        for (Student stu : this.allotStudents) {
            System.out.println(stu);
        }



    }


}


class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qualified = scan.nextInt();
        int vacancy = scan.nextInt();
        int unreserved = scan.nextInt();
        int bcNo = scan.nextInt();
        int scNo = scan.nextInt();
        int stNo = scan.nextInt();

        StudentsData data = new StudentsData(qualified, vacancy, unreserved, vacancy - unreserved, bcNo, scNo, stNo);

        while(scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            try {
                data.addStudent(new Student(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),
                Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]),tokens[6]));    
            } catch (Exception e) {
                //empty tokens array due to input glitch.
            }
            
        }


        
        data.showMeritList();
        System.out.println();
        data.showAlloted();
    }



}