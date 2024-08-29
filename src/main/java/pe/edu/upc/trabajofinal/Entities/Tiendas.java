package pe.edu.upc.trabajofinal.Entities;
import jakarta.persistence.*;

@Entity

public class Tiendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre",nullable = false,length = 10)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length =100)
    private String descripcion;
    @Column(name = "direccion", nullable = false, length =30)
    private String direccion;

    public Tiendas() {}

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

