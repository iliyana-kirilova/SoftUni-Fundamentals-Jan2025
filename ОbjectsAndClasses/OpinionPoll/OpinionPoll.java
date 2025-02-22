package Week7_objectsAndClasses.OpinionPoll;

public class OpinionPoll {
    //Fields
    private String name;
    private int age;

    //Constructor
    public OpinionPoll(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Methods
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

}
