package FinalExamPrep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab13_BakeryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map <String, Integer> foodList = new LinkedHashMap<>();
        int soldGoods = 0;
        while (!input.equals("Complete")){
            String command = input.split(" ")[0];
            int quantity = Integer.parseInt(input.split(" ")[1]);
            String food = input.split(" ")[2];
            if (command.equals("Receive")){
                if (foodList.containsKey(food)){
                    int currentQuantity = foodList.get(food);
                    if (currentQuantity<0){
                        continue;
                    } else {
                        foodList.put(food, quantity+currentQuantity);
                    }
                } else {
                    if (quantity<0){
                        continue;
                    }else {
                        foodList.put(food, quantity);
                    }
                }
            } else if (command.equals("Sell")) {
                if (!foodList.containsKey(food)){
                    System.out.printf("You do not have any %s.%n", food);
                } else if (foodList.containsKey(food)) {
                    int currentQuantity = foodList.get(food);
                    if (currentQuantity>=quantity){
                        System.out.printf("You sold %d %s.%n", quantity, food);
                        soldGoods +=quantity;
                        foodList.put(food, currentQuantity-quantity);
                        if (foodList.get(food)==0){
                            foodList.remove(food);
                        }
                    } else if (currentQuantity<quantity) {
                        System.out.printf("There aren't enough %s. You sold the last %d of them.%n", food, currentQuantity);
                        soldGoods+=currentQuantity;
                        foodList.remove(food);
                    }
                }
            }

            input = scanner.nextLine();
        }
        foodList.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.printf("All sold: %d goods", soldGoods);

    }
}
