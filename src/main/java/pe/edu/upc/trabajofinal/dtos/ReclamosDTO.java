package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.trabajofinal.Entities.Pedido;

import java.time.LocalDate;

public class ReclamosDTO {
    private int idReclamos;
    private String contenidoReclamo;
    private LocalDate fechaReclamo;
    private Pedido p;

    public int getIdReclamos() {
        return idReclamos;
    }

    public void setIdReclamos(int idReclamos) {
        this.idReclamos = idReclamos;
    }

    public String getContenidoReclamo() {
        return contenidoReclamo;
    }

    public void setContenidoReclamo(String contenidoReclamo) {
        this.contenidoReclamo = contenidoReclamo;
    }

    public LocalDate getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(LocalDate fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public Pedido getP() {
        return p;
    }

    public void setP(Pedido p) {
        this.p = p;
    }
}
