package repository.impl;

import entities.User;
import repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users;

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
        boolean searched = false;
        for (User currentUser: users) {
            if(user.getId().equals(currentUser.getId())){
                searched = true;
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
                currentUser.setMiddleName(user.getMiddleName());
                currentUser.setEmail(user.getEmail());
                currentUser.setPhone(user.getPhone());
                currentUser.setStatus(user.getStatus());
            }
        }
        if(!searched)
            this.users.add(user);
        return user;
    }

    @Override
    public List<User> saveAll(List<User> users){
        for (User user: this.users) {
            boolean searched = false;
            for (User currentUser: users) {
                if(currentUser.getId().equals(user.getId())){
                    searched = true;
                    user.setFirstName(currentUser.getFirstName());
                    user.setLastName(currentUser.getLastName());
                    user.setMiddleName(currentUser.getMiddleName());
                    user.setEmail(currentUser.getEmail());
                    user.setPhone(currentUser.getPhone());
                    user.setStatus(currentUser.getStatus());
                }
            }
            if(!searched)
                this.users.add(user);
        }
        return users;
    }
}
