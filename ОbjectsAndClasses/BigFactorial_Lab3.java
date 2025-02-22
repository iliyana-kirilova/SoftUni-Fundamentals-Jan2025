package Week7_objectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial_Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <=number ; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
}
