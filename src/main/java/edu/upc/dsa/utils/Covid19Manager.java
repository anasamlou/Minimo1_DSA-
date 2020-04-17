package edu.upc.dsa.utils;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Casos;

import java.util.List;

public interface Covid19Manager {
    public List<Brote> getBrotes();
    public void crearBrote(String id);
    public void addCasoToBrote(String id, Casos caso);
    public void addCasoToBrote(String idobj, String idcaso, String fechanacimiento, String nivelderiesgo, Boolean sospechoso, Boolean confirmado, Boolean nocaso);
    public List<Casos> getCasosOrdenados(String idbrote);
    public void clear();
    public Brote getBroteById(String id);

}
