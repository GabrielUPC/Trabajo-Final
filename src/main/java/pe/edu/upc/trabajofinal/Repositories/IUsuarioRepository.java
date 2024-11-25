package pe.edu.upc.trabajofinal.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String username);
    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    @Query(value = "select u.nombre, r.contenido_reclamo, r.fecha_reclamo\n" +
            "from usuario u\n" +
            "join productos p on u.id_usuario = p.id_usuario\n" +
            "join carritox_producto c on p.id_producto = c.id_producto\n" +
            "join pedido pe on c.id_carrito = pe.id_carrito\n" +
            "join reclamos r on pe.id = r.id\n" +
            "where pe.estado='Entregado'",nativeQuery = true)
    List<String[]> UsuarioReclamo();
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rolename, id_usuario) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
