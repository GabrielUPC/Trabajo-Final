package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;

import java.util.List;

@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Integer> {
    @Query("SELECT m FROM MetodoPago m WHERE m.tipo = :tipo")
    List<MetodoPago> findMetodoPagoByTipo(@Param("tipo") String tipo);
}
