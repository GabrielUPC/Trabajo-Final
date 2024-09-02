package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;
import pe.edu.upc.trabajofinal.Repositories.IMetodoPagoRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IMetodoPagoInterface;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoImplements implements IMetodoPagoInterface {

    @Autowired
    private IMetodoPagoRepository metodoPagoRepository;

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public MetodoPago update(MetodoPago metodoPago) {
        // Check if the MetodoPago exists before updating
        Optional<MetodoPago> existingMetodoPago = metodoPagoRepository.findById(metodoPago.getId());
        if (existingMetodoPago.isPresent()) {
            return metodoPagoRepository.save(metodoPago);
        } else {
            throw new IllegalArgumentException("MetodoPago con ID " + metodoPago.getId() + " no existe.");
        }
    }

    @Override
    public void deleteById(Integer id) {
        // Check if the MetodoPago exists before deleting
        Optional<MetodoPago> existingMetodoPago = metodoPagoRepository.findById(id);
        if (existingMetodoPago.isPresent()) {
            metodoPagoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("MetodoPago con ID " + id + " no existe.");
        }
    }

    @Override
    public Optional<MetodoPago> findById(Integer id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }
}
