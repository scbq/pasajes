package com.mycompany.aerolinea_2;

/**
 *
 * @author felipeaguilerafuentealba
 */
public class Persona {
     //Atributos
    
    private int id;
    
    
    private String nombre;
    private String rut;
    private String telefono;

    //Constructores
    public Persona() {
    }

    public Persona(int id, String nombre, String rut, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    //Get y Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
