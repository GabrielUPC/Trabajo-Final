package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Roles;
@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer> {
}
