package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Productos;

import java.util.List;

@Repository
public interface IProductos extends JpaRepository<Productos,Integer> {
    @Query(value ="select p.nombre_producto as Producto, o.nombre_oferta, o.fecha_inicio, o.fecha_fin, o.cantidad_productos\n" +
            "from productos p\n" +
            "join oferta o on p.id_ofertas = o.id_oferta \n" +
            "where o.fecha_fin >= current_date" ,nativeQuery = true )
    List<String[]> ProductoEnOfeta();


    @Query(value ="SELECT r.calificacion, r.comentarios, r.fecha \n" +
            "FROM review r \n" +
            "JOIN productos p ON r.id_producto = p.id_producto \n" +
            "WHERE p.nombre_producto  = 'dulcesss';" ,nativeQuery = true)

    List<String[]> ObtenerResenasProducto(@Param("nombreProducto") String nombreProducto);
}
