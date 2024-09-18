package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.IOfertaRepository;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IOfertaInterface;

import java.util.List;

@Service
public class OfertaServiceImplements implements IOfertaInterface {
    @Autowired
    private IOfertaRepository oR;
    @Override
    public List<Oferta> list() {
        return oR.findAll();
    }

    @Override
    public void add(Oferta oferta) {
        oR.save(oferta);
    }

    @Override
    public Oferta listId(int id) {
        return oR.findById(id).orElse(new Oferta());
    }

    @Override
    public void modificar(Oferta oferta){oR.save(oferta);   }

    @Override
    public void eliminar(int id) {oR.deleteById(id);    }

    @Override
    public List<String[]> ofertasactivas() {
        return oR.ofertasactivas();
    }
}
