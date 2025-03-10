package Week8_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex4_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, String> users = new LinkedHashMap<>();
        for (int i = 1; i <=count ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String username = input[1];


            if (command.equals("register")){
                String plateNumber = input[2];
                if (users.containsKey(username)){
                    System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                } else {
                    users.put(username,plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                }
            } else if (command.equals("unregister")) {
                if (users.containsKey(username)){
                    users.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }
        }

        users.entrySet().forEach(entry-> System.out.println(entry.getKey()+ " => "+ entry.getValue()));
    }

}
