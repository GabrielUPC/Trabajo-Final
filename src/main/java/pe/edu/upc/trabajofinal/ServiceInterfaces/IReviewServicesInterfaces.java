package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Review;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

public interface IReviewServicesInterfaces {
    public List<Review> list();
    public void add(Review review);
    public Review listId(int id);
    public void modificar(Review review);
    public void eliminar(int id);

}
