package Week7_objectsAndClasses.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List <Person> people = new ArrayList<>();
        while (!input.equals("End")){
            String name = input.split(" ")[0];
            String numberOfID = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Person person = new Person(name, numberOfID, age);
            people.add(person);

            input = scanner.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));
        for (Person person : people) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getNumberOfID(), person.getAge());
        }
    }
}
