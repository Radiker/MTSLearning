package repository.impl;

import entities.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll(){
        return users;
    }

    @Override
    public User getBy(String id){
        for (User user: users) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    @Override
    public User save(User user){
        User currentUser = getBy(user.getId());
        if(currentUser != null){
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setMiddleName(user.getMiddleName());
            currentUser.setEmail(user.getEmail());
            currentUser.setPhone(user.getPhone());
            currentUser.setStatus(user.getStatus());
        }
        else
            this.users.add(user);
        return user;
    }

    @Override
    public List<User> saveAll(List<User> users){
        for (User user: this.users) {
            User currentUser = getBy(user.getId());
            if (currentUser != null) {
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
                currentUser.setMiddleName(user.getMiddleName());
                currentUser.setEmail(user.getEmail());
                currentUser.setPhone(user.getPhone());
                currentUser.setStatus(user.getStatus());
            } else
                this.users.add(user);
        }
        return users;
    }
}
