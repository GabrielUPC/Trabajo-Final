package pe.edu.upc.trabajofinal.ServiceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import java.util.List;


public interface IUsuarioInterfaces {

    public List<Usuario>list();
    public void add(Usuario usuario);
    public Usuario listId(int id);
    public void modificar(Usuario usuario);
    public void eliminar(int id);
    List<String[]> UsuarioReclamo();
    public int getUserIdFromUsername(String username);

}
