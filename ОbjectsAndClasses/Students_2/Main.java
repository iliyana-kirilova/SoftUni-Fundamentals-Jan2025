package Week7_objectsAndClasses.Students_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Students_2> names = new ArrayList<>();
        while (!input.equals("end")){
            String[] data = input.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];


            if (isStudentExisting(names, firstName,lastName)){
                int index = getExistingIndex(names, firstName, lastName);
                names.get(index).setAge(age);
                names.get(index).setHometown(hometown);
            } else {
                Students_2 student = new Students_2(firstName, lastName, age, hometown);
                names.add(student);
            }
            input = scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Students_2 student : names) {
            if (city.equals(student.getHometown())){
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    static boolean isStudentExisting (List<Students_2> names, String firstName, String lastName){
        for (Students_2 student : names) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
    public static int getExistingIndex (List<Students_2> studentsList, String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < studentsList.size(); i++) {
            Students_2 student = studentsList.get(i);
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                index = i;
            }
        }
        return index;
    }
}
