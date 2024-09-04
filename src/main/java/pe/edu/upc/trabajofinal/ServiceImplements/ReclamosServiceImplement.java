package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Reclamos;
import pe.edu.upc.trabajofinal.Repositories.IReclamosRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoInterface;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IReclamosInterface;

import java.util.List;
@Service
public class ReclamosServiceImplement implements IReclamosInterface {
    @Autowired
    private IReclamosRepository rR;
    @Override
    public List<Reclamos> list() {
        return rR.findAll();
    }

    @Override
    public void add(Reclamos reclamos) {
    rR.save(reclamos);
    }

    @Override
    public Reclamos listId(int id) {
        return rR.findById(id).orElse(new Reclamos());
    }

    @Override
    public void modificar(Reclamos reclamos) {
        rR.save(reclamos);
    }

    @Override
    public void eliminar(int id) {
    rR.deleteById(id);
    }
}
