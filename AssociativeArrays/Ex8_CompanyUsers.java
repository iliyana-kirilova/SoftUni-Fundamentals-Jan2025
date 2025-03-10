package Week8_AssociativeArrays;

import java.util.*;

public class Ex8_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companyData = new LinkedHashMap<>();
        while (!input.equals("End")){
            String companyName = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            companyData.putIfAbsent(companyName, new ArrayList<>());
            boolean isAlreadyThere = companyData.get(companyName).contains(employeeID);

            if (!isAlreadyThere) {
                companyData.get(companyName).add(employeeID);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String , List<String>> entry:companyData.entrySet()){
            String companyName = entry.getKey();
            List<String> employeeID = entry.getValue();

            System.out.println(companyName);
            employeeID.forEach(id-> System.out.println("-- "+id));

        }
    }
}
