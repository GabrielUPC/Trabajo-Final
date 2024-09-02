package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

@Entity
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Nombre", nullable=false, length = 30)
    private String nombre;

    @Column(name="Tipo", nullable=false, length = 30)
    private String tipo;

    // Foreign Key (FK) - Relación con otra entidad (CarritoXProducto) mmm no iria creo
    /// @ManyToOne
    ///  @JoinColumn(name = "CarritoxProducto_id", nullable = false)
    /// private CarritoXProducto carritoXProducto; // Esto es una relación ManyToOne
    // Constructor por defecto
    public MetodoPago() {
    }
    public MetodoPago(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters y Setters
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

}
