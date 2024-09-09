package pe.edu.upc.trabajofinal.dtos;

public class ProductoCantidadDTO {
    private int pcantidad;
    private String nombreProducto;

    public int getPcantidad() {
        return pcantidad;
    }

    public void setPcantidad(int pcantidad) {
        this.pcantidad = pcantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
