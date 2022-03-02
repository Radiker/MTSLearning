package services;

import entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(String FIO, String phone, String email);
    void deleteUsers(List<Long> ids);
    void updateUser();
    void createUser();
}
