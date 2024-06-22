package ai.verisoft;

public class Person {
    private String firstName;
    private String lastName;
    public Person(String jane, String doe) {
        this.firstName = jane;
        this.lastName = doe;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
