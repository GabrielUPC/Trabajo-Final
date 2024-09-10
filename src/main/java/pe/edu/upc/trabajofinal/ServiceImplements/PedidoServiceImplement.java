package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Pedido;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.Repositories.IPedidoRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IPedidoInterface;

import java.time.LocalDate;
import java.util.List;
@Service
public class PedidoServiceImplement implements IPedidoInterface {
    @Autowired
    private IPedidoRepository pR;
    @Override
    public List<Pedido> list() {
        return pR.findAll();
    }

    @Override
    public void add(Pedido pedido) {
        pR.save(pedido);
    }

    @Override
    public Pedido listId(int id) {
        return pR.findById(id).orElse(new Pedido());
    }

    @Override
    public void modificar(Pedido pedido) {
        pR.save(pedido);
    }

    @Override
    public List<Pedido> findPedidosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return pR.findPedidosEntreFechas(fechaInicio,fechaFin);
    }

    @Override
    public void eliminar(int id) {
        pR.deleteById(id);
    }
}
