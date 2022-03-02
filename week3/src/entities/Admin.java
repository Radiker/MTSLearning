package entities;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AbstractUser{
    public Admin(){
        super();
    }

    public Admin(String firstName, String lastName, String middleName, String phone){
        super(firstName, lastName, middleName, phone);
    }
}
