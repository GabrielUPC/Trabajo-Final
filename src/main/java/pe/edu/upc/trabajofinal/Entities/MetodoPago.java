package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

@Entity
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Nombre", nullable=false, length = 30)
    private String nombre;

    @Column(name="Tipo", nullable=false, length = 30)
    private String tipo;
    @ManyToOne
    @JoinColumn(name="idProductos")
    private Productos p;

    public MetodoPago() {
    }

    public MetodoPago(int id, String nombre, String tipo, Productos p) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.p = p;
    }

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
