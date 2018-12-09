package ua.i.sonne.homework4;

import java.util.Arrays;
import java.util.Comparator;

public class Group implements Voenkom {

    private Student[] students = new Student[10];

    public Group() {
    }

    public Group(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    /**
     * Method adds student to group
     *
     * @param student
     */
    public void addStudent(Student student) throws GroupOverflowException {
        if (student == null) {
            System.out.println("Error adding student");
            return;
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                System.out.println("Student " + student + " added");
                return;
            }
        }
        throw new GroupOverflowException("No available room for student");
    }

    /**
     * Method remove student from the group
     *
     * @param number
     */
    public void removeStudent(int number) {
        if (number >= 0 && number <= 10) {
            students[number] = null;
        }
    }

    /**
     * Method search student in group by surname
     *
     * @param surname
     */
    public Student searchStudentBySurname(String surname) {
        for (int i = 0; i < students.length; i++) {
            try {
                if (students[i].getSurname().equals(surname)) {
                    return students[i];
                }
            } catch (NullPointerException e) {
            }
        }
        return null;
    }

    /**
     * Method sort students by sort parameter
     *
     * @param param sort parameter
     *              1 --> Surname ascending
     *              2 --> Surname descending
     *              3 --> Age ascending
     *              4 --> Age descending
     *              5 --> Record Book ascending
     *              6 --> Record Book descending
     */
    public void sortStudents(int param) {
        if (param > 0 && param < 7) {
            Student.setSortParam(param);
            Arrays.sort(students, Comparator.nullsLast(Student::compareTo));
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            sb.append(students[i]).append("\n");
        }
        return sb.toString();
    }

    /**
     * Method search recruits for army
     *
     * @return boy and man older 18
     */
    @Override
    public Student[] findRecruit() {
        Student[] recruit;
        int counter = 0;
        for (int i = 0; i < students.length; i++) {
            try {
                if (students[i].isMale() && students[i].getAge() > 18) {
                    counter++;
                }
            } catch (NullPointerException e) {

            }
        }
        recruit = new Student[counter];
        for (int i = 0, j = 0; i < counter; j++) {
            try {
                if (students[j].isMale() && students[j].getAge() > 18) {
                    recruit[i] = students[j];
                    i++;
                }
            }catch (NullPointerException e){

        }
    }
        return recruit;
}
}
