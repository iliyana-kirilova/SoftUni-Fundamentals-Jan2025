package Week7_objectsAndClasses.Students_Ex;

public class Students {
    private String firstName;
    private String lastName;
    private double grade;

    public Students (String firstName, String lastName, double grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrade() {
        return grade;
    }
}
