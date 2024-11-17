package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Pedido;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("SELECT p FROM Pedido p WHERE p.fechaEntrega BETWEEN :fechaInicio AND :fechaFin")
    List<Pedido> findPedidosEntreFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
    @Query(value = "select id_pedido,estado,fecha_entrega,fechac_pedido from pedido pe\n" +
            "join carritox_producto cp on cp.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join productos p on p.id_producto = cp.id_producto\n" +
            "join usuario u on u.id_usuario = p.id_usuario\n" +
            "where u.id_usuario=:id%",nativeQuery = true)
    public List<String[]> UsuarioPedido(@Param("id") int id);
    @Query(value = "select id_pedido,estado,fechac_pedido,fecha_entrega from pedido pe\n" +
            "join carritox_producto cp on cp.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join carrito ca on ca.id=cp.id_carrito\n" +
            "where ca.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findPedidosByUsuarioId(@Param("usuarioId") int usuarioId);
    @Query(value = "select id_pedido,estado,fechac_pedido,fecha_entrega from pedido pe\n" +
            "join carritox_producto cp on cp.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join productos pr on pr.id_producto=cp.id_producto\n" +
            "join usuario u on u.id_usuario=pr.id_usuario\n" +
            "where u.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findPedidosVendedor(@Param("usuarioId") int usuarioId);
    @Query(value = "select id_pedido,(ca.cantidad*po.precio_producto)as totalxpedido from pedido pe\n" +
            "join carritox_producto ca on ca.id_carritoxproducto=pe.id_carritoxproducto\n" +
            "join productos po on po.id_producto=ca.id_producto\n" +
            "where po.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> MontoxPedido(@Param("usuarioId") int usuarioId);
}
