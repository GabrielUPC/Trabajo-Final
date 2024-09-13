package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Carrito;

import java.util.List;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Integer> {
    @Query(value = "SELECT u.id_usuario, \n" +
            "       car.id_carrito, \n" +
            "       SUM(car.precio_total) AS precio_total_carrito\n" +
            "FROM pedido ped\n" +
            "INNER JOIN usuario u ON u.id_usuario = u.id_usuario  -- Ajusta según el nombre correcto de la columna\n" +
            "INNER JOIN carrito car ON ped.id_carrito = car.id_carrito\n" +
            "WHERE u.id_usuario = 1234 \n" +
            "  AND ped.fechac_pedido = '2024-01-12'\n" +
            "GROUP BY u.id_usuario, car.id_carrito;\n", nativeQuery = true)
    public List<String[]> gastototalusuariopormes();

}
