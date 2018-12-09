package ua.i.sonne.homework4;

public class Human {

    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private boolean male;

    public Human() {
    }

    /**
     * Constructor
     * @param name
     * @param surname
     * @param patronymic
     * @param age
     * @param male
     */
    public Human(String name, String surname, String patronymic, int age, boolean male) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", male=" + male +
                '}';
    }
}

