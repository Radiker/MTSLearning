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
    public void deleteUsers(List<Long> ids) {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void createUser() {

    }
}
