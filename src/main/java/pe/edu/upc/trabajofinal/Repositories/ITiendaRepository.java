package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Tiendas;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

@Repository
public interface ITiendaRepository extends JpaRepository<Tiendas, Integer> {
    @Query("select t from Tiendas t where t.nombre like %:nombre%")
    public List<Tiendas> Buscar(@Param("nombre") String nombre);
}
