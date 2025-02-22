package Week7_objectsAndClasses.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List <Student> studentsList = new ArrayList<>();

        while (!input.equals("end")){
            String [] data = input.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];

            Student student = new Student(firstName, lastName, age, hometown);
            studentsList.add(student);
            input = scanner.nextLine();
        }

        String city = scanner.nextLine();
        for (Student student : studentsList) {
            if (student.getHometown().equals(city)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
