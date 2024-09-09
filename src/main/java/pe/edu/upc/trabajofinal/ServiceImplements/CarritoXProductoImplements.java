package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.CarritoXProducto;
import pe.edu.upc.trabajofinal.Repositories.ICarritoXProductoRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoXProductoInterface;

import java.util.List;

@Service
public class CarritoXProductoImplements implements ICarritoXProductoInterface {
    @Autowired
    private ICarritoXProductoRepository cP;
    @Override
    public List<CarritoXProducto> list() {
        return cP.findAll();
    }

    @Override
    public void add(CarritoXProducto carritoXProducto) {
        cP.save(carritoXProducto);
    }

    @Override
    public CarritoXProducto listId(int id) {
        return cP.findById(id).orElse(new CarritoXProducto());
    }

    @Override
    public void modificar(CarritoXProducto carritoXProducto) {
        cP.save(carritoXProducto);
    }

    @Override
    public void eliminar(int id) {
        cP.deleteById(id);
    }
}