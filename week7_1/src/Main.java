import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("1","Иванов","Иван","Иванович",UserStatus.ACTIVE));
        users.add(new User("2","Петров","Петр","Петрович",UserStatus.BANNED));
        users.add(new User("3","Сидоров","Сидор","Сидорович",UserStatus.ACTIVE));
        users.add(new User("4","Алексеев","Алексей","Алексеевич",UserStatus.BANNED));
        users.add(new User("5","Иванов","Петр","Сидорович",UserStatus.ACTIVE));

        getActiveUsers(users).stream().forEach(user -> System.out.println(user.toString()));

        toStringAllUsers(users).forEach(user -> System.out.println(user));

        allUserToConsole(users);
    }

    public static class User{
        private String id;
        private String firstName;
        private String lastName;
        private String middleName;
        private UserStatus status;

        public User(String id, String firstName, String lastName, String middleName, UserStatus status) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public UserStatus getStatus() {
            return status;
        }

        public void setStatus(UserStatus status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", status=" + status +
                    '}';
        }
    }

    public enum UserStatus{
        ACTIVE, BANNED
    }

    public static List<User> getActiveUsers(List<User> users){
        return users.stream().filter(user -> user.getStatus() == UserStatus.ACTIVE).collect(Collectors.toList());
    }

    public static List<String> toStringAllUsers(List<User> users){
        //return users.stream().map(user -> user.toString()).collect(Collectors.toList());
        return users.stream().map(User::toString).collect(Collectors.toList());
    }

    public static void allUserToConsole(List<User> users){
        //users.stream().forEach(user -> System.out.println(user.toString()));
        users.stream().forEach(System.out::println);
    }
}