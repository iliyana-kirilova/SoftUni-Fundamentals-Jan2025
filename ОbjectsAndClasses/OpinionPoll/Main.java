package Week7_objectsAndClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<OpinionPoll> users = new ArrayList<>();

        for (int i = 1; i <=n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            OpinionPoll person = new OpinionPoll(name, age);
            if (person.getAge()>30){
                users.add(person);
            }
        }
        for (OpinionPoll user : users) {
            System.out.println(user.getName()+ " - "+ user.getAge());
        }
    }
}
