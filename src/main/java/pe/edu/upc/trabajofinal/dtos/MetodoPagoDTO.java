package pe.edu.upc.trabajofinal.dtos;

public class MetodoPagoDTO {

    private Integer id;
    private String nombre;
    private String tipo;
    //private Integer carritoXProductoId; // FK

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

    //public Integer getCarritoXProductoId() {
    //return carritoXProductoId;
    //}

    //public void setCarritoXProductoId(Integer carritoXProductoId) {
    //this.carritoXProductoId = carritoXProductoId;
    //}
}
