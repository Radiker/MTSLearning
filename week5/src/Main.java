import java.lang.reflect.Array;
import java.security.PrivateKey;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 1);
        Cat cat2 = new Cat("Барсик", 1);
        Set<Cat> cats = new HashSet<>();
        cats.add(cat1);
        cats.add(cat2);

        for (Cat cat: cats) {
            System.out.println(cat); // {барсик, 1}
        }

        List<String> words = new ArrayList<>(Arrays.asList("RED", "YELLOW"));
        System.out.println(getUniqueInAlphabeticOrder(words));

        Organization calipso = new Organization("calipso", "123123");
        Organization sber = new Organization("sber", "321321");

        User vanya = new User("ivan", "ivanov", "ivanovich", "123123", calipso);
        User petya = new User("petya", "petrov", "petrovich", "123123", calipso);

        User lesha = new User("alexey", "alexeev", "alexeevich", "123123", sber);

        Map<Organization, List<User>> groupedOrganizations = groupByOrganization(new ArrayList<>(List.of(vanya, petya, lesha)));

        System.out.println("sber : " + groupedOrganizations.get(sber));
        System.out.println("calipso : " + groupedOrganizations.get(calipso));
    }

    public static class Cat{
        private String name;
        private Integer age;

        public Cat(){
            this.name = "Кот";
            this.age = 1;
        }

        public Cat(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return Objects.equals(name, cat.name) && Objects.equals(age, cat.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static List<String> getUniqueInAlphabeticOrder(List<String> words) {
        Set<String> treeSetOfStrings = new TreeSet<>(words);
        return treeSetOfStrings.stream().toList();
    }

    public static class User{
        private String firstName;
        private String lastName;
        private String middleName;
        private String phone;
        private Organization organization;

        public User(String firstName, String lastName, String middleName, String phone, Organization organization) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.phone = phone;
            this.organization = organization;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Organization getOrganization() {
            return organization;
        }

        public void setOrganization(Organization organization) {
            this.organization = organization;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(middleName, user.middleName) && Objects.equals(phone, user.phone) && Objects.equals(organization, user.organization);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, middleName, phone, organization);
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", organization=" + organization +
                    '}';
        }
    }

    public static class Organization {
        private String name;
        private String inn;

        public Organization(String name, String inn) {
            this.name = name;
            this.inn = inn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInn() {
            return inn;
        }

        public void setInn(String inn) {
            this.inn = inn;
        }

        @Override
        public String toString() {
            return "Organization{" +
                    "name='" + name + '\'' +
                    ", inn='" + inn + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Organization that = (Organization) o;
            return Objects.equals(name, that.name) && Objects.equals(inn, that.inn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, inn);
        }
    }

    public static Map<Organization, List<User>> groupByOrganization(List<User> users) {
        Map<Organization, List<User>> hashMap = new HashMap<>();
        for (User user :  users){
            Organization organization = user.getOrganization();
            if(hashMap.get(organization) == null)
                hashMap.put(organization, new ArrayList<>(List.of(user)));
            else
                hashMap.get(organization).add(user);
            }
        return hashMap;
    }
}
