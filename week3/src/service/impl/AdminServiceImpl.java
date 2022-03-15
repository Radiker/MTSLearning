package service.impl;

import entities.Client;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    @Override
    public void ban(Client client) {
        client.setBanned(true);
    }

    @Override
    public void unban(Client client) {
        client.setBanned(false);
    }
}
