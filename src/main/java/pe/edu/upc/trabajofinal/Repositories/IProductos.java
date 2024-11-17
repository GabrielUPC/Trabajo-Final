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


    
    @Query(value = "select t.nombre as \"Tienda\", Sum(p.precio_producto*c.cantidad) as \"Ganancia Total\"\n" +
            "from productos p\n" +
            "join tiendas t on p.id_tiendas = t.id_tiendas\n" +
            "join carritox_producto c on p.id_producto = c.id_producto\n" +
            "group by t.nombre", nativeQuery = true)
    List<String[]> GananciaTotalPorTienda();

    @Query(value = "select nombre_producto,stock_producto from productos po \n" +
            "where po.stock_producto<10;",nativeQuery = true)
    List<String[]> ProductosConMenorStock();
    @Query(value = "select po.nombre_producto , count(ca.id_carritoxproducto) from pedido pe\n" +
            "join carritox_producto ca on ca.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join productos po on po.id_producto=ca.id_producto\n" +
            "where po.id_usuario=:usuarioId\n" +
            "GROUP BY po.nombre_producto",nativeQuery = true)
    public List<String[]> productosmasvendidos(@Param("usuarioId") int usuarioId);

}
