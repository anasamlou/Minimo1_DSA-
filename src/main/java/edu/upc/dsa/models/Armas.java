package edu.upc.dsa.models;

public class Armas {
    String id;
    String descrp;

    public Armas(String idd, String d){
        this.id = idd;
        this.descrp = d;
    }

    public Armas(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }
}
