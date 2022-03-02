package entities;

public abstract class AbstractUser {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getMiddleName() {
        return this.middleName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }

    public AbstractUser(){
        this.firstName = "Иван";
        this.lastName = "Иванов";
        this.middleName = "Иванович";
        this.phone = "88001234567";
    }

    public AbstractUser(String firstName, String lastName, String middleName, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
    }
}
