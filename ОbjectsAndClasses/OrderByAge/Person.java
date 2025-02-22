package Week7_objectsAndClasses.OrderByAge;

public class Person {
    private String name;
    private String numberOfID;
    private int age;

    public Person(String name, String numberOfID, int age){
        this.name = name;
        this.numberOfID = numberOfID;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfID() {
        return numberOfID;
    }

    public int getAge() {
        return age;
    }
}
