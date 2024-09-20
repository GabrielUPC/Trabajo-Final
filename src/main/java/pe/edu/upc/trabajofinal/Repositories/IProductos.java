package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Productos;

import java.util.List;

@Repository
public interface IProductos extends JpaRepository<Productos,Integer> {
    @Query(value ="select p.nombre_producto as \"Productos Vencidos\"\n" +
            "            from productos p\n" +
            "            where p.fecha_vencimiento_producto < current_date" ,nativeQuery = true )
    List<String[]> ProductoVencidos();


    @Query(value ="SELECT r.calificacion, r.comentarios, r.fecha \n" +
            "FROM review r \n" +
            "JOIN productos p ON r.id_producto = p.id_producto \n" +
            "WHERE p.nombre_producto  = 'dulcesss';" ,nativeQuery = true)

    List<String[]> ObtenerResenasProducto(@Param("nombreProducto") String nombreProducto);
    @Query(value = "select t.nombre as \"Tienda\", Sum(p.precio_producto*c.cantidad) as \"Ganancia Total\"\n" +
            "from productos p\n" +
            "join tiendas t on p.id_tiendas = t.id_tiendas\n" +
            "join carritox_producto c on p.id_producto = c.id_producto\n" +
            "group by t.nombre", nativeQuery = true)
    List<String[]> GananciaTotalPorTienda();
}
