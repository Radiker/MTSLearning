package entities;

import java.util.UUID;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;
    private UserStatus status = UserStatus.ACTIVE;

    public User(){
        this.id = UUID.randomUUID().toString();
        this.firstName = "Иван";
        this.lastName = "Иванов";
        this.middleName = "Иванович";
        this.phone = "7999999999";
        this.email = "example@example.com";
    }

    public User(String id, String firstName, String lastName, String middleName, String phone, String email){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
    }

    public String getId(){
        return this.id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public String getMiddleName(){
        return this.middleName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setStatus(UserStatus status){
        this.status = status;
    }
    public UserStatus getStatus(){
        return this.status;
    }
}
