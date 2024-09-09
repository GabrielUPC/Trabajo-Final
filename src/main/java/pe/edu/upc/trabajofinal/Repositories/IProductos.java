package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Productos;

import java.util.List;

@Repository
public interface IProductos extends JpaRepository<Productos,Integer> {
    @Query(value = " select \n" +
            "    p.nombre AS NombreProducto,\n" +
            "    p.stockProducto as CantidadEnStock,\n" +
            "    COALESCE(SUM(c.cantidadCarrito), 0)as CantidadVendida\n" +
            " from \n" +
            "    Productos p\n" +
            " left join \n" +
            "    CarritoxProducto c on p.idProducto = c.Productos_id\n" +
            " left join \n" +
            "    Carrito ca on c.Carrito_id = ca.idCarrito\n" +
            " where \n" +
            "    ca.estadoCarrito = 'Completado'  -- Filtra solo los carritos completados\n" +
            " group by \n" +
            "    p.idProducto, p.nombre, p.stockProducto;\n", nativeQuery = true)
    public List<String[]> pcantidad();

}
