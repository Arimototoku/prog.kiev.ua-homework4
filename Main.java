package ua.i.sonne.homework4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            showMenu(1);
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number, please");
                continue;
            }
            switch (choice) {
                case 1:
                    try {
                        group.addStudent(createStudent());
                    } catch (GroupOverflowException e) {
                        System.out.println("Error adding a Student");
                    }
                    break;
                case 2:
                    System.out.println(group);
                    break;
                case 3:
                    group.sortStudents(1);
                    break;
                case 4:
                    showMenu(2);
                    try {
                        choice = Integer.parseInt(scanner.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a number, please");
                        continue;
                    }
                    if (choice == 7) {
                        continue;
                    }
                    group.sortStudents(choice);
                    break;
                case 5:
                    showGroup(group);
                    try {
                        choice = Integer.parseInt(scanner.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a number, please");
                        continue;
                    }
                    group.removeStudent(choice - 1);
                    break;
                case 6:
                    System.out.println(Arrays.toString(group.findRecruit()));
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a number between 1 to 7, please");
                    continue;


            }
        }
    }

    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        try {
            System.out.println("Name:");
            student.setName(scanner.next());
            System.out.println("Surname:");
            student.setSurname(scanner.next());
            System.out.println("Patronymic:");
            student.setPatronymic(scanner.next());
            System.out.println("Age:");
            student.setAge(scanner.nextInt());
            System.out.println("Male (y - yes, other - no):");
            student.setMale(scanner.next().equals("y"));
            System.out.println("Record book (int):");
            student.setRecordBook(scanner.nextInt());
            System.out.println("Group:");
            student.setGroup(scanner.next());
            return student;
        } catch (InputMismatchException e) {
            return null;
        }
    }

    public static void showMenu(int menu) {
        if (menu == 1) {
            System.out.println("Make your choice");
            System.out.println("1 -> Add Student to the group");
            System.out.println("2 -> View Students in the group");
            System.out.println("3 -> Sort Students in the group by Surname");
            System.out.println("4 -> Change sort parameters");
            System.out.println("5 -> Delete Student");
            System.out.println("6 -> Find Recruit");
            System.out.println("7 -> Exit program");
        } else if (menu == 2) {
            System.out.println("What parameter do you want to sort?");
            System.out.println("1 --> Surname ascending");
            System.out.println("2 --> Surname descending");
            System.out.println("3 --> Age ascending");
            System.out.println("4 --> Age descending");
            System.out.println("5 --> Record Book ascending");
            System.out.println("6 --> Record Book descending");
            System.out.println("7 --> Main Menu");
        }
    }

    public static void showGroup(Group group) {
        for (int i = 0; i < group.getStudents().length; i++) {
            System.out.print(i + 1 + " --> " + group.getStudents()[i] + "\n");
        }
    }
}




