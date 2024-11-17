package pe.edu.upc.trabajofinal.ServiceImplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;
import pe.edu.upc.trabajofinal.Repositories.ICarritoxProductoRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoxProductoInterfaces;

import java.util.List;

@Service
public class CarritoxProductoImplements implements ICarritoxProductoInterfaces {
    @Autowired
    private ICarritoxProductoRepository cpR;
    @Override
    public List<CarritoxProducto> list() {
        return cpR.findAll();
    }

    @Override
    public CarritoxProducto findById(int id) {
        return cpR.findById(id).orElse(new CarritoxProducto());
    }

    @Override
    public void add(CarritoxProducto producto) {
        cpR.save(producto);
    }

    @Override
    public void modificar(CarritoxProducto producto) {
        cpR.save(producto);
    }

    @Override
    public void eliminar(int id) {
        cpR.deleteById(id);
    }

    @Override
    public List<String[]> findCarritosUsuarioId(int usuarioId) {
        return cpR.findCarritosUsuarioId(usuarioId);
    }


}
