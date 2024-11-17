package pe.edu.upc.trabajofinal.ServiceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

public interface IOfertaInterface {
    public List<Oferta> list();
    public void add(Oferta oferta);
    public Oferta listId(int id);
    public void modificar(Oferta oferta);
    public void eliminar(int id);
    public List<String[]> ofertasactivas();
    public List<String[]> findOfertasByUsuarioId(@Param("usuarioId") int usuarioId);
}
