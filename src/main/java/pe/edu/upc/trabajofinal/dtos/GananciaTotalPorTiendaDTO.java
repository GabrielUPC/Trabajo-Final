package pe.edu.upc.trabajofinal.dtos;

public class GananciaTotalPorTiendaDTO {
    private String tienda;
    private Double gananciaTotal;

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public Double getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(Double gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
    }
}
