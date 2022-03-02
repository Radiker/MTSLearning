package entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends AbstractUser {
    private Boolean banned;
    private List<Book> books;

    public Client(){
        super();
        this.banned = false;
        this.books = new ArrayList<>();
    }

    public Client(String firstName, String lastName, String middleName, String phone){
        super(firstName, lastName, middleName, phone);
        this.banned = false;
        this.books = new ArrayList<>();
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }
    public Boolean getBanned() {
        return this.banned;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Book> getBooks() {
        return this.books;
    }
}
