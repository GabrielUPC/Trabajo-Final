package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Review;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IReviewServicesInterfaces;
import pe.edu.upc.trabajofinal.dtos.ReviewDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private IReviewServicesInterfaces rS;
    @GetMapping
    private List<ReviewDTO> list(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ReviewDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    private void save(@RequestBody ReviewDTO dto){
        ModelMapper m=new ModelMapper();
        Review r=m.map(dto, Review.class);
        rS.add(r);
    }
    @GetMapping("/{id}")
    private ReviewDTO findById(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ReviewDTO r=m.map(rS.listId(id), ReviewDTO.class);
        return r;
    }
    @PutMapping
    private void update(@RequestBody ReviewDTO dto){
        ModelMapper m=new ModelMapper();
        Review r=m.map(dto, Review.class);
        rS.modificar(r);
    }
    @DeleteMapping
    private void deletebyid(@PathVariable("id") Integer id){
        rS.eliminar(id);
    }
}
