package pe.edu.upc.trabajofinal.dtos;

public class ProductosMenorStockDTO {
    public String nombre;
    public int stock;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
