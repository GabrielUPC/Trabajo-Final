package pe.edu.upc.trabajofinal.ServiceImplements;

import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Repositories.ICarritoRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoInterface;

import java.util.List;
@Service
public class CarritoServiceImplement implements ICarritoInterface {
    @Autowired
    private ICarritoRepository cR;
    @Override
    public List<Carrito> list() {
        return cR.findAll();
    }

    @Override
    public void add(Carrito carrito) {
        cR.save(carrito);
    }

    @Override
    public Carrito listId(int id) {
        return cR.findById(id).orElse(new Carrito());
    }

    @Override
    public void modificar(Carrito carrito) {
        cR.save(carrito);
    }

    @Override
    public void eliminar(int id) {
    cR.deleteById(id);
    }

    @Override
    public List<String[]> gastototalusuariopormesService() {
        return cR.gastototalusuariopormes();
    }
}
