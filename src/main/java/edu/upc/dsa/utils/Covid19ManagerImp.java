package edu.upc.dsa.utils;

import edu.upc.dsa.models.Casos;
import edu.upc.dsa.models.Brote;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Covid19ManagerImp implements Covid19Manager {

    private HashMap<String, Brote> myBrote;
    final static Logger logger = Logger.getLogger(Covid19ManagerImp.class);

    private static Covid19Manager instance;


    private Covid19ManagerImp(){
        this.myBrote = new HashMap<String, Brote>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImp();
        return instance;
    }

    @Override
    public List<Brote> getBrotes() {
        List<Brote> broteList = new LinkedList<Brote>(this.myBrote.values());
        return broteList;
    }

    @Override
    public void crearBrote(String id) {
        logger.info("entering to crearBrote");
        Brote u = new Brote(id);
        this.myBrote.put(u.getId(),u);
        logger.info("New brote registered with id: " + u.getId());
    }




    @Override
    public void addCasoToBrote(String idbrote, String idcaso, String fechanacimiento, String nivelderiesgo, Boolean sospechoso, Boolean confirmado, Boolean nocaso)
    {
        logger.info("entering to addCasoToBrote");
        Brote brote = this.myBrote.get(idbrote);
        Casos caso = new Casos(idcaso,fechanacimiento,nivelderiesgo,sospechoso,confirmado,nocaso);
        brote.addCaso2(idcaso,fechanacimiento,nivelderiesgo,sospechoso,confirmado,nocaso);
        this.myBrote.put(idbrote,brote);
        logger.info(brote.getId() + " received: " + caso.getId());
    }
    @Override
    public void addCasoToBrote(String idbrote,Casos caso)
    {
        logger.info("Entering no addCasoToBrote");
        Brote brote = this.myBrote.get(idbrote);
        brote.addCaso(caso);
        this.myBrote.put(idbrote,brote);
        logger.info(brote.getId() + " received: " + caso.getId());
    }



    @Override
    public List<Casos> getCasosOrdenados(String idbrote) {
        logger.info("Entering to getCasosOrdenados");
        List<Casos> casos = new LinkedList<Casos>(this.myBrote.get(idbrote).getCasos());
        List<Casos> ordenados = new LinkedList<Casos>();
        for (int i=0; i<casos.size(); i++)
        {
            if (casos.get(i).getSospechoso() == Boolean.TRUE){
                ordenados.add(casos.get(i));
            }
            else{
                i++;
            }
        }
        for (int i=ordenados.size(); i<casos.size(); i++)
        {
            if (casos.get(i).getConfirmado() == Boolean.TRUE){
                ordenados.add(casos.get(i));
            }
            else{
                i++;
            }
        }
        for (int i=ordenados.size(); i<casos.size(); i++)
        {
            if (casos.get(i).getSospechoso() == Boolean.TRUE){
                ordenados.add(casos.get(i));
            }
            else{
                i++;
            }
        }
        Collections.sort(casos);
        logger.info("Sorted: "+casos);
        return casos;
        }
    @Override
    public void clear() {
        instance = null;
        this.myBrote.clear();
        logger.info("Closing..........");
    }

    @Override
    public Brote getBroteById(String id) {
        List<Brote> broteList = new LinkedList<Brote>(this.myBrote.values());
        return myBrote.get(id);
    }
}
