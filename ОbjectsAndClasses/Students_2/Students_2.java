package Week7_objectsAndClasses.Students_2;

public class Students_2 {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;


    public Students_2 (String firstName, String lastName, int age, String hometown){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}


