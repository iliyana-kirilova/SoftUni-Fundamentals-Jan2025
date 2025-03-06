package Week8_AssociativeArrays;

import java.util.*;

public class Lab1_countRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersCount = new TreeMap<>();
        for (double number : numbers) {
            if (!numbersCount.containsKey(number)){
                numbersCount.put(number,1);
            }else {
                int currentCount = numbersCount.get(number);
                numbersCount.put(number, currentCount+1);
            }
        }

        for(Map.Entry<Double, Integer> entry: numbersCount.entrySet()){
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
