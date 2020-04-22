package edu.upc.dsa.models;

import java.util.Date;

public class CasoBrote {
    String idbrote;
    String idcaso;
    Date fechanacimiento;
    String nivelderiesgo;
    String estado;

    public String getIdbrote() {
        return idbrote;
    }

    public void setIdbrote(String idbrote) {
        this.idbrote = idbrote;
    }

    public String getIdcaso() {
        return idcaso;
    }

    public void setIdcaso(String idcaso) {
        this.idcaso = idcaso;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNivelderiesgo() {
        return nivelderiesgo;
    }

    public void setNivelderiesgo(String nivelderiesgo) {
        this.nivelderiesgo = nivelderiesgo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CasoBrote(String idbrote, String idcaso, Date fechanacimiento, String nivelderiesgo, String estado) {
        this.idbrote = idbrote;
        this.idcaso = idcaso;
        this.fechanacimiento = fechanacimiento;
        this.nivelderiesgo = nivelderiesgo;
        this.estado = estado;
    }

    public CasoBrote() {
    }
}
