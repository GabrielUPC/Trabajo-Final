package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Oferta;

import java.util.List;

@Repository
public interface IOfertaRepository extends JpaRepository<Oferta,Integer> {
    @Query(value = "select id_oferta,nombre_oferta,fecha_inicio,fecha_fin,cantidad FROM Oferta o \n" +
            "WHERE o.fecha_Inicio <= NOW() AND o.fecha_Fin >= NOW();\n",nativeQuery = true)
    public List<String[]> ofertasactivas();
    @Query(value = "SELECT id_oferta,nombre_oferta,fecha_inicio,fecha_fin,cantidad FROM oferta o WHERE o.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findOfertasByUsuarioId(@Param("usuarioId") int usuarioId);
}
