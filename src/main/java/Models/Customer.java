package Models;


public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public Customer(int customerID, String firstName, String lastName,
                    int age, String email) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(int newID) {
        this.customerID = newID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

}
