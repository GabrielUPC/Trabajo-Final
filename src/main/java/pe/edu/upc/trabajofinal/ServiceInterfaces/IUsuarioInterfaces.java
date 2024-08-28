package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Usuario;
import java.util.List;


public interface IUsuarioInterfaces {

    public List<Usuario>list();
    public void add(Usuario usuario);
    public Usuario listId(int id);
    public void modificar(Usuario usuario);
    public void eliminar(int id);

}
