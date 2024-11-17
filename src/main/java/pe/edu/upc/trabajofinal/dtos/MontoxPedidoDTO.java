package pe.edu.upc.trabajofinal.dtos;

public class MontoxPedidoDTO {
    private  int id_pedido;
    private  double montototal;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getMontototal() {
        return montototal;
    }

    public void setMontototal(double montototal) {
        this.montototal = montototal;
    }
}
