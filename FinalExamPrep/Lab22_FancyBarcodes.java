package FinalExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab22_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "@[#]+[A-Z][a-zA-Z0-9]{4,}[A-Z]@[#]+";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                StringBuilder productGroup = new StringBuilder();
                for (char symbol : input.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        productGroup.append(symbol);
                    }
                }

                if (productGroup.isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup.toString());
                }
            }else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
