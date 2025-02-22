package Week7_objectsAndClasses.Students_Ex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Students student = new Students(firstName, lastName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparing(Students::getGrade).reversed());
        for (Students student : students) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
