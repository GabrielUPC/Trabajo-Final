package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;

import java.util.List;

@Repository
public interface ICarritoxProductoRepository extends JpaRepository<CarritoxProducto,Integer> {
    @Query(value = "Select id_carritoxproducto,cantidad from carritox_producto cp\n" +
            "join carrito ca on ca.id=cp.id_carrito\n" +
            "where ca.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findCarritosUsuarioId(@Param("usuarioId") int usuarioId);
}
