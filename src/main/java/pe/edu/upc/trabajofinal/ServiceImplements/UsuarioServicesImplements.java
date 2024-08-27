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
}
