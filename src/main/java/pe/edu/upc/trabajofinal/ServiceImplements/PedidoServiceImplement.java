package pe.edu.upc.trabajofinal.ServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Pedido;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.IPedidoRepository;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IPedidoInterface;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImplement implements IPedidoInterface {
    @Autowired
    private IPedidoRepository pedidoRepository;
    @Autowired
    private IUsuarioRepository ur;
    @Override
    public List<Pedido> list() {
        return pedidoRepository.findAll();
    }

    @Override
    public void add(Pedido pedido) {

        pedidoRepository.save(pedido);
    }

    @Override
    public Pedido listId(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void modificar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void eliminar(int id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> findPedidosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return pedidoRepository.findPedidosEntreFechas(fechaInicio, fechaFin);
    }

    @Override
    public List<String[]> findPedidosByUsuarioId(int usuarioId) { // Implementación del nuevo método
        return pedidoRepository.findPedidosByUsuarioId(usuarioId);
    }

    @Override
    public List<String[]> findPedidosVendedor(int usuarioId) {
        return pedidoRepository.findPedidosVendedor(usuarioId);
    }

    @Override
    public List<String[]> MontoxPedido(int usuarioId) {
        return pedidoRepository.MontoxPedido(usuarioId);
    }
}
