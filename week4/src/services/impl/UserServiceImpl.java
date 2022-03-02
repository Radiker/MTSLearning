package services.impl;

import entities.User;
import entities.UserStatus;
import repository.UserRepository;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers(String FIO, String phone, String email) {
        List<User> users = new ArrayList<>();
        String[] name = FIO.split(" ");
        for (User user : userRepository.getAll()) {
            if(user.getLastName().equals(name[0]) && user.getFirstName().equals(name[1]) &&
               user.getMiddleName().equals(name[2]) && user.getPhone().equals(phone) &&
               user.getEmail().equals(email) && user.getStatus() == UserStatus.ACTIVE)
                users.add(user);
        }
        return users;
    }

    @Override
    public void deleteUsers(List<User> users) {
        for (User user : users) {
            User currentUser = userRepository.getBy(user.getId());
            currentUser.setStatus(UserStatus.DELETED);
            user = currentUser;
        }
        userRepository.saveAll(users);
    }

    @Override
    public User updateUser(String id, String firstName, String lastName, String middleName, String phone, String email){
        User user = userRepository.getBy(id);
        if(user.getStatus() == UserStatus.DELETED){
            System.out.println("Can't update user with id " + user.getId() +", because it's status is DELETED");
            return user;
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setPhone(phone);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public User createUser(String firstName, String lastName, String middleName, String phone, String email) {
        User user = new User(firstName, lastName, middleName, phone, email);
        return userRepository.save(user);
    }
}
