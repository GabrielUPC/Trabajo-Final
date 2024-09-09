package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;
    @Column(name="calificacion", nullable=false)
    private int calificacion;
    @Column(name="fecha", nullable=false)
    private LocalDate fecha;
    @Column(name="comentarios", nullable=false,length = 100)
    private String comentarios;
    @ManyToOne
    @JoinColumn(name="idProducto")
    private Productos producto;
    
    public Review() {
    }

    public Review(int idReview, int calificacion, LocalDate fecha, String comentarios, Productos producto) {
        this.idReview = idReview;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.producto = producto;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}
