package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface IMetodoPagoInterface {

    MetodoPago save(MetodoPago metodoPago);
    MetodoPago update(MetodoPago metodoPago);
    void deleteById(Integer id);
    Optional<MetodoPago> findById(Integer id);
    List<MetodoPago> findAll();
}
