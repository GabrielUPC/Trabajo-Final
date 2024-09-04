package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.*;
import pe.edu.upc.trabajofinal.Entities.Productos;

public class MetodoPagoDTO {


    private int id;


    private String nombre;


    private String tipo;

    private Productos p;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Productos getP() {
        return p;
    }

    public void setP(Productos p) {
        this.p = p;
    }
}
