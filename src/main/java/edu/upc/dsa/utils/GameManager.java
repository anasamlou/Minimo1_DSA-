package edu.upc.dsa.utils;

import edu.upc.dsa.models.User;

import java.util.List;

public interface GameManager {
    public List<User> getUsers();
    public void addUser(String name, String lastname,String id);
    public void updateUser(String name, String lastname, String id);
    public int getNumUsers();
    public User getUser(String iduser);
    public void addArmasUser(String iduser, String idobj, String desc);
    public int getnumArmasbyUser(String iduser);
    public void clear();
}
