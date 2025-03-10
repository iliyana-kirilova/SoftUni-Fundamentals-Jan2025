package Week8_AssociativeArrays;

import java.util.*;

public class Ex6_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map <String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 1; i <= count ; i++) {
            String studentName = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());
            if (students.containsKey(studentName)) {
                List<Double> currentGrades = students.get(studentName);
                currentGrades.add(grade);
            }
            else {
                students.put(studentName, new ArrayList<>());
                students.get(studentName).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry:students.entrySet()){
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade = getAverageGrade(grades);

            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", studentName, averageGrade);
            }
        }
    }
    private static double getAverageGrade(List<Double> grades){
        double sum = 0;
        for (Double grade : grades) {
            sum+=grade;
        }
        return sum/grades.size();
    }
}

