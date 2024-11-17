package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.IOfertaRepository;
import pe.edu.upc.trabajofinal.Repositories.IServicioCliente;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IOfertaInterface;

import java.util.List;

@Service
public class OfertaServiceImplements implements IOfertaInterface {
    @Autowired
    private IOfertaRepository oR;
    @Autowired
    private IUsuarioRepository ur;
    @Override
    public List<Oferta> list() {
        return oR.findAll();
    }

    @Override
    public void add(Oferta o) {
        if (o.getU() != null && o.getU().getIdUsuario() != 0) {
            // Verifica si el usuario ya está en la base de datos
            Usuario usuarioPersistido = ur.findById(o.getU().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Asigna el usuario completamente inicializado al ServicioCliente
            o.setU(usuarioPersistido);
        } else {
            throw new RuntimeException("Usuario no especificado o ID de usuario no válido");
        }
        oR.save(o);
    }

    @Override
    public Oferta listId(int id) {
        return oR.findById(id).orElse(new Oferta());
    }

    @Override
    public void modificar(Oferta oferta){
        if (oferta.getU() != null && oferta.getU().getIdUsuario() != 0) {
            // Recupera el usuario existente por su ID
            Usuario usuarioPersistido = ur.findById(oferta.getU().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Asigna el usuario existente a la oferta
            oferta.setU(usuarioPersistido);
        } else {
            throw new RuntimeException("Usuario no especificado o ID de usuario no válido");
        }
        oR.save(oferta);   }

    @Override
    public void eliminar(int id) {oR.deleteById(id);    }

    @Override
    public List<String[]> ofertasactivas() {
        return oR.ofertasactivas();
    }

    @Override
    public List<String[]> findOfertasByUsuarioId(int usuarioId) {
        return oR.findOfertasByUsuarioId(usuarioId);
    }
}
