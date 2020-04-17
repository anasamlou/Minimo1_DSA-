package edu.upc.dsa.models;

import java.util.LinkedList;

public class User implements Comparable<User>{
    String id;
    String name;
    String lastname;
    LinkedList<Armas> armas;

    public User(String n, String ln, String id){
        this.name = n;
        this.lastname = ln;
        this.armas = new LinkedList<Armas>();
        this.id = id;
    }

    public User(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public LinkedList<Armas> getArmas() {
        return armas;
    }

    public void setArmas(LinkedList<Armas> armas) {
        this.armas = armas;
    }

    public void addArmas(Armas obj){ this.armas.add(obj); }


    @Override
    public int compareTo(User u) {
        if (getLastname() == null || u.getLastname() == null) {
            return 0;
        }
        return getLastname().compareTo(u.getLastname());
    }
}
