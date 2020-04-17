package edu.upc.dsa.models;

public class Casos implements Comparable<Casos> {
    String id;
    String nombre;
    String apellido;
    String fechanacimiento;
    String nivelderiesgo;
    String genero;
    String mail;
    String telefono;
    String direccion;
    Boolean sospechoso;
    Boolean confirmado;
    Boolean nocaso;

    @Override
    public String toString() {
        return "Casos{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechanacimiento='" + fechanacimiento + '\'' +
                ", nivelderiesgo='" + nivelderiesgo + '\'' +
                ", genero='" + genero + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sospechoso=" + sospechoso +
                ", confirmado=" + confirmado +
                ", nocaso=" + nocaso +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Casos(String id, String fechanacimiento, String nivelderiesgo, Boolean sospechoso, Boolean confirmado, Boolean nocaso) {
        this.id = id;
        this.fechanacimiento = fechanacimiento;
        this.nivelderiesgo = nivelderiesgo;
        this.sospechoso = sospechoso;
        this.confirmado = confirmado;
        this.nocaso = nocaso;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNivelderiesgo() {
        return nivelderiesgo;
    }

    public void setNivelderiesgo(String nivelderiesgo) {
        this.nivelderiesgo = nivelderiesgo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Boolean sospechoso) {
        this.sospechoso = sospechoso;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Boolean getNocaso() {
        return nocaso;
    }

    public void setNocaso(Boolean nocaso) {
        this.nocaso = nocaso;
    }

    public Casos(String id, String nombre, String apellido, String fechanacimiento, String nivelderiesgo, String genero, String mail, String telefono, String direccion, Boolean sospechoso, Boolean confirmado, Boolean nocaso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.nivelderiesgo = nivelderiesgo;
        this.genero = genero;
        this.mail = mail;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sospechoso = sospechoso;
        this.confirmado = confirmado;
        this.nocaso = nocaso;
    }

    @Override
    public int compareTo(Casos u) {
        if (getFechanacimiento() == null || u.getFechanacimiento() == null) {
            return 0;
        }
        return getFechanacimiento().compareTo(u.getFechanacimiento());
    }

}