package zero23ku.doman;

public class User {

    private String rut;
    private String nombre;

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRut(){
        return this.rut;
    }

    public void setNombre(String nombre){ 
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}