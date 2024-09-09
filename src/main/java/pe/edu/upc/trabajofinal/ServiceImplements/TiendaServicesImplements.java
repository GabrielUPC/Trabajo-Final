package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Tiendas;

import pe.edu.upc.trabajofinal.Repositories.ITiendaRepository;

import pe.edu.upc.trabajofinal.ServiceInterfaces.ITiendaInterfaces;

import java.util.List;
@Service
public class TiendaServicesImplements implements ITiendaInterfaces {
    @Autowired
    private ITiendaRepository tiendaRepository;
    @Override
    public List<Tiendas> list(){
        return tiendaRepository.findAll();
    }

    @Override
    public void add(Tiendas tiendas) {
        tiendaRepository.save(tiendas);
    }

    @Override
    public Tiendas listId(int id) {
        return tiendaRepository.findById(id).orElse(new Tiendas());
    }

    @Override
    public void modificar(Tiendas tiendas) {
        tiendaRepository.save(tiendas);
    }

    @Override
    public void eliminar(int id) {
        tiendaRepository.deleteById(id);
    }

    @Override
    public List<Tiendas> Buscar(String nombre) {
        return tiendaRepository.Buscar(nombre);
    }


}
