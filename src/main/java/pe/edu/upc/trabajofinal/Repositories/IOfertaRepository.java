package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Oferta;

import java.util.List;

@Repository
public interface IOfertaRepository extends JpaRepository<Oferta,Integer> {
    @Query(value = "SELECT \n" +
            "    o.nombre_oferta\n" +
            "FROM \n" +
            "    Oferta o\n" +
            "WHERE \n" +
            "    o.Fecha_Inicio <= NOW() \n" +
            "    AND o.Fecha_Fin >= NOW();\n",nativeQuery = true)
    public List<String[]> ofertasactivas();
}
