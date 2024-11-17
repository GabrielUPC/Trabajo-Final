package pe.edu.upc.trabajofinal.ServiceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoInterface {
    public List<Pedido> list();
    public void add(Pedido pedido);
    public Pedido listId(int id);
    public void modificar(Pedido pedido);
    public void eliminar(int id);
    public List<Pedido> findPedidosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public List<String[]> findPedidosByUsuarioId(int usuarioId);
    public List<String[]> findPedidosVendedor(int usuarioId);
    public List<String[]> MontoxPedido(int usuarioId);
}
