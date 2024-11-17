package pe.edu.upc.trabajofinal.ServiceImplements;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.IServicioCliente;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IServicioClienteInterfaces;

import java.util.List;
@Service
public class ServicioClienteServiceImplement implements IServicioClienteInterfaces {
    @Autowired
    private IServicioCliente sC;
    @Autowired
    private IUsuarioRepository ur;
    @Override
    public List<ServicioCliente> list() {
        return sC.findAll();
    }

    @Override
    public void insert(ServicioCliente sc) {
        if (sc.getU() != null && sc.getU().getIdUsuario() != 0) {
            Usuario usuarioPersistido = ur.findById(sc.getU().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            sc.setU(usuarioPersistido);
        } else {
            throw new RuntimeException("Usuario no especificado o ID de usuario no válido");
        }
        sC.save(sc);
    }

    @Override
    public ServicioCliente listId(int id) {
        return sC.findById(id).orElse(new ServicioCliente());
    }

    @Override
    public void modificar(ServicioCliente Sc) {
        sC.save(Sc);
    }

    @Override
    public void eliminar(int id) {
        sC.deleteById(id);
    }

    @Override
    public List<String[]> findServiciosByUsuarioId(int usuarioId) {
        return sC.findServiciosByUsuarioId(usuarioId);
    }
}
