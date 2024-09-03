package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Productos;

@Repository
public interface IProductos extends JpaRepository<Productos,Integer> {
}
