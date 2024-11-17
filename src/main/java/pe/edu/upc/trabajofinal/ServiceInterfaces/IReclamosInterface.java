package pe.edu.upc.trabajofinal.ServiceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Reclamos;

import java.util.List;

public interface IReclamosInterface {
    public List<Reclamos> list();
    public void add(Reclamos reclamos);
    public Reclamos listId(int id);
    public void modificar(Reclamos reclamos);
    public void eliminar(int id);
    public List<String[]> findReclamosByUsuarioId(int usuarioId);
    public List<String[]> findReclamosalVendedor(@Param("usuarioId") int usuarioId);
}
