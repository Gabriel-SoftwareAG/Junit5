package ai.verisoft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testPerson() {
        Person person = new Person("John", "Doe");
        String firstName = person.getFirstName();
//        String lastName = person.getLastName();
        assertEquals("John2", firstName, "Name should be John2");

    }
}
