package edu.upc.dsa.models;

import java.util.LinkedList;

public class Brote {
    String id;
    LinkedList<Casos> casos;

    public Brote() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<Casos> getCasos() {
        return casos;
    }

    public void setCasos(LinkedList<Casos> casos) {
        this.casos = casos;
    }

    public Brote(String id) {
        this.id = id;
    }

    public void addCaso(Casos caso){
        this.casos.add(caso); }

    public void addCaso2(String idcaso, String fechanacimiento, String nivelderiesgo,String estado){
        Casos caso = new Casos(idcaso,fechanacimiento,nivelderiesgo,estado);
        this.casos.add(caso); }



}
