package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;

import java.util.List;
@Service
public class UsuarioServicesImplements implements IUsuarioInterfaces {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    @Override
    public void add(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario listId(int id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Override
    public void modificar(Usuario usuario) {
         usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<String[]> UsuarioReclamo() {
        return usuarioRepository.UsuarioReclamo();
    }


    public int getUserIdFromUsername(String username) {
        Usuario usuario = usuarioRepository.findOneByUsername(username);
        return usuario != null ? usuario.getIdUsuario() : -1; // Retorna -1 si no se encuentra el usuario
    }
}
