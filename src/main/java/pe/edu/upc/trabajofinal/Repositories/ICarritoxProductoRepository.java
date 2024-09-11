package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;

import java.util.List;

@Repository
public interface ICarritoxProductoRepository extends JpaRepository<CarritoxProducto,Integer> {

    @Query(value = " select sum(cp.cantidadCarrito * p.precioProducto) as monto_total\n" +
            " from CarritoxProducto cp\n" +
            " join Productos p on cp.producto.idProducto = p.idProducto\n" +
            " where cp.carrito.idCarrito = :idCarrito;", nativeQuery = true)
    Double calcularMontoTotal(@Param("idCarrito") int idCarrito);

}
