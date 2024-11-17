package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.ICarritoRepository;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoInterfaces;

import java.util.List;

@Service
public class CarritoImplements implements ICarritoInterfaces {
    @Autowired
    private ICarritoRepository cr;
    @Autowired
    private IUsuarioRepository ur;
    @Override
    public List<Carrito> list() {
        return cr.findAll();
    }

    @Override
    public Carrito findById(int id) {
        return cr.findById(id).orElse(new Carrito());
    }

    @Override
    public void add(Carrito carrito) {
        if (carrito.getU() != null && carrito.getU().getIdUsuario() != 0) {
            Usuario usuarioPersistido = ur.findById(carrito.getU().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            carrito.setU(usuarioPersistido);
        } else {
            throw new RuntimeException("Usuario no especificado o ID de usuario no válido");
        }
        cr.save(carrito);
    }

    @Override
    public void modificar(Carrito carrito) {
        cr.save(carrito);
    }

    @Override
    public void eliminar(int id) {
        cr.deleteById(id);
    }

    @Override
    public List<String[]> findCarritosByUsuarioId(int usuarioId) {
        return cr.findCarritosByUsuarioId(usuarioId);
    }
}
