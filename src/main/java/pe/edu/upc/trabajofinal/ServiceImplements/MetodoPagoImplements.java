package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;
import pe.edu.upc.trabajofinal.Repositories.IMetodoPagoRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IMetodoPagoInterface;

import java.util.List;


@Service
public class MetodoPagoImplements implements IMetodoPagoInterface {

    @Autowired
    private IMetodoPagoRepository mR;


    @Override
    public List<MetodoPago> list() {
        return mR.findAll();
    }

    @Override
    public void save(MetodoPago metodoPago) {
        mR.save(metodoPago);
    }

    @Override
    public MetodoPago listid(int id) {
        return mR.findById(id).orElse(new MetodoPago());
    }

    @Override
    public void modificar(MetodoPago metodoPago) {
        mR.save(metodoPago);
    }

    @Override
    public void deleteById(int id) {
        mR.deleteById(id);
    }


}
