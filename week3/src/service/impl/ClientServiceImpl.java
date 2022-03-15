package service.impl;

import entities.Book;
import entities.Client;
import service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Override
    public void takeBooks(Client client, List<Book> books){
        List<Book> clientBooks = client.getBooks();
        clientBooks.addAll(books);
        client.setBooks(clientBooks);
    }
    @Override
    public void returnBooks(Client client, List<Book> books){
        List<Book> clientBooks = client.getBooks();
        clientBooks.removeAll(books);
        client.setBooks(clientBooks);
    }
}
