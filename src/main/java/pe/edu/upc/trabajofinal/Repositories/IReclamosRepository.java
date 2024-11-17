package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Reclamos;

import java.util.List;

@Repository
public interface IReclamosRepository extends JpaRepository<Reclamos, Integer> {
    @Query(value = "SELECT id_reclamos,contenido_reclamo,fecha_reclamo FROM reclamos re\n" +
            "join pedido pe on pe.id_pedido=re.id\n" +
            "join carritox_producto cp on cp.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join carrito ca on ca.id=cp.id_carrito\n" +
            "where ca.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findReclamosByUsuarioId(@Param("usuarioId") int usuarioId);
    @Query(value = "SELECT id_reclamos,contenido_reclamo,fecha_reclamo FROM reclamos re\n" +
            "join pedido pe on pe.id_pedido=re.id\n" +
            "join carritox_producto cp on cp.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join productos pr on pr.id_producto=cp.id_producto\n" +
            "where pr.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findReclamosalVendedor(@Param("usuarioId") int usuarioId);
}
