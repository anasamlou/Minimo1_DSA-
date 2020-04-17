package edu.upc.dsa.utils;

import edu.upc.dsa.models.Armas;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameManagerImp implements GameManager{

    private HashMap<String, User> allUsers;
    final static Logger logger = Logger.getLogger(GameManagerImp.class);

    private static GameManager instance;


    private GameManagerImp(){
        this.allUsers = new HashMap<String, User>();
    }

    public static GameManager getInstance() {
        if (instance==null) instance = new GameManagerImp();
        return instance;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new LinkedList<User>(this.allUsers.values());
        Collections.sort(userList);
        return userList;
    }

    @Override
    public void addUser(String name, String lastname,String id) {
        User u = new User(name,lastname, id);
        this.allUsers.put(u.getId(),u);
        logger.info(u.getName() + " " + u.getLastname() + " registered with id: " + u.getId());
    }

    @Override
    public void updateUser(String name, String lastname,  String id) {
        User u = this.allUsers.get(id);
        this.allUsers.remove(id);
        u.setName(name);
        u.setLastname(lastname);
        this.allUsers.put(id,u);
        logger.info("User modified to: " + u.getName() + " " + u.getLastname() + " having this id: " + u.getId() );
    }

    @Override
    public int getNumUsers() {
        return allUsers.size();
    }

    @Override
    public User getUser(String iduser) {
        return allUsers.get(iduser);
    }

    @Override
    public void addArmasUser(String iduser, String idobj, String descp) {
        User u = this.allUsers.get(iduser);
        Armas obj = new Armas(idobj,descp);
        u.addArmas(obj);
        this.allUsers.put(iduser,u);
        logger.info(u.getId() + " received: " + obj.getId());
    }

    @Override
    public int getnumArmasbyUser(String iduser) {
        User u = this.allUsers.get(iduser);
        return u.getArmas().size();
    }

    @Override
    public void clear() {
        instance = null;
        this.allUsers.clear();
        logger.info("Closing..........");
    }
}
