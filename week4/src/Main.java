import entities.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        userService.createUser("Иван", "Иванов", "Иванович", "7999999999", "Ivanov@mail.ru");
        userService.createUser("Петр", "Петров", "Петрович", "7999999998", "Petrov@mail.ru");
        System.out.println("Users added successfully");

        //Проверка обновление данных заблокированого пользователя
        String userName = "Иванов Иван Иванович";
        List<User> users = userService.getUsers(userName, "7999999999", "Ivanov@mail.ru");

        if(users.size() != 0)
            for (User user : users){
                System.out.println("User with id " + user.getId() + " searched");
            }
        else
            System.out.println("Users not found");

        userService.deleteUsers(users);

        User searchedUser = users.get(0);

        userService.updateUser(searchedUser.getId(), searchedUser.getFirstName(), searchedUser.getLastName(),
                searchedUser.getMiddleName(), searchedUser.getPhone(), "example@mail.ru");

        //Проверка обновление данных незаблокированого пользователя
        userName = "Петров Петр Петрович";
        users = userService.getUsers(userName, "7999999998", "Petrov@mail.ru");

        if(users.size() != 0)
            for (User user : users){
                System.out.println("User with id " + user.getId() + " searched");
            }
        else
            System.out.println("Users not found");

        searchedUser = users.get(0);

        userService.updateUser(searchedUser.getId(), searchedUser.getFirstName(), searchedUser.getLastName(),
                searchedUser.getMiddleName(), searchedUser.getPhone(), "example@mail.ru");

    }
}



