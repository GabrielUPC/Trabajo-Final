package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoInterface {
    public List<Pedido> list();
    public void add(Pedido pedido);
    public Pedido listId(int id);
    public void modificar(Pedido pedido);
    public List<Pedido> findPedidosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public void eliminar(int id);
}
