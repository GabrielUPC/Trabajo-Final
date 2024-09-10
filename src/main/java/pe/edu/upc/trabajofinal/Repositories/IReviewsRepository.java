package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajofinal.Entities.Review;

import java.util.List;

@Repository
public interface IReviewsRepository extends JpaRepository <Review,Integer> {
    @Query(value = " SELECT r.calificacion,r.comentarios,r.fecha\n" +
            " FROM review r\n" +
            " JOIN Productos p ON r.id_producto = p.id_producto\n" +
            " WHERE p.id_producto =: id;",nativeQuery = true)
    public List<String []> reviewproductos(@Param("id") int id);
}