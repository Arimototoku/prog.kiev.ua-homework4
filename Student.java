package ua.i.sonne.homework4;

public class Student extends Human implements Comparable {

    private int recordBook;
    private String group;
    /**
     * 1 --> Surname ascending
     * 2 --> Surname descending
     * 3 --> Age ascending
     * 4 --> Age descending
     * 5 --> Record Book ascending
     * 6 --> Record Book descending
     */
    private static int sortParam;

    public Student() {
    }

    public Student(String name, String surname, String patronymic, int age, boolean male, int recordBook, String group) {
        super(name, surname, patronymic, age, male);
        this.recordBook = recordBook;
        this.group = group;
    }

    public int getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(int recordBook) {
        this.recordBook = recordBook;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static int getSortParam() {
        return sortParam;
    }

    public static void setSortParam(int sortParam) {
        Student.sortParam = sortParam;
    }

    @Override
    public String toString() {
        return "Student{" +
                "recordBook=" + recordBook +
                ", group='" + group + '\'' +
                "} " + super.toString();
    }

    @Override
    public int compareTo(Object other) {
        if (other == null) return -1;
        Student otherStudent = (Student) other;
        switch (sortParam) {
            case 1:
                return this.getSurname().compareTo(otherStudent.getSurname());
            case 2:
                return -(this.getSurname().compareTo(otherStudent.getSurname()));
            case 3:
                return this.getAge() - otherStudent.getAge();
            case 4:
                return otherStudent.getAge() - this.getAge();
            case 5:
                return this.getRecordBook() - otherStudent.getRecordBook();
            case 6:
                return otherStudent.getRecordBook() - this.getRecordBook();
            default:
                return 0;
        }
    }


}
