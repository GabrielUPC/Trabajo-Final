package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Review;
import pe.edu.upc.trabajofinal.Repositories.IReviewsRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IReviewServicesInterfaces;

import java.util.List;
@Service
public class ReviewImplements implements IReviewServicesInterfaces {
    @Autowired
    private IReviewsRepository rR;
    @Override
    public List<Review> list() {
        return rR.findAll();
    }

    @Override
    public void add(Review review) {
        rR.save(review);
    }

    @Override
    public Review listId(int id) {
        return rR.findById(id).orElse(new Review());
    }

    @Override
    public void modificar(Review review) {
        rR.save(review);
    }

    @Override
    public void eliminar(int id) {
        rR.deleteById(id);
    }
}
