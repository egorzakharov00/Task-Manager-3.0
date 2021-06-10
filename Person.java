// class for Person objects
public class Person {

    // initialise Person attributes
    String name;
    String number; // Number can have + or can start with 0 thus must be a string
    String email;
    String address;

    // Person constructor
    public Person(String name, String number, String email, String address) {

        // set Person attributes
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;

    }

    // change email using set method
    public void setEmail(String email) {
        this.email = email;
    }

    // change telephone number using set method
    public void setNumber(String number) {
        this.number = number;
    }

}
