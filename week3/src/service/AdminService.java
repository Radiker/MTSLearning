package service;

import entities.Client;

public interface AdminService {
    void ban(Client client);
    void unban(Client client);
}
