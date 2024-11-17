package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    private Usuario u;

    public Carrito() {
    }

    public Carrito(int id, Usuario u) {
        this.id = id;
        this.u = u;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
}
