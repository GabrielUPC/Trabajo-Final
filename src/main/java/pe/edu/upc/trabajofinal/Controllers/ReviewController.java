package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Review;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IReviewServicesInterfaces;
import pe.edu.upc.trabajofinal.dtos.ReporteOfertaActivas;
import pe.edu.upc.trabajofinal.dtos.ReviewDTO;
import pe.edu.upc.trabajofinal.dtos.ReviewProductosDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private IReviewServicesInterfaces rS;
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @GetMapping
    private List<ReviewDTO> list(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ReviewDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('COMPRADOR')")
    @PostMapping
    private void save(@RequestBody ReviewDTO dto){
        ModelMapper m=new ModelMapper();
        Review r=m.map(dto, Review.class);
        rS.add(r);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    private ReviewDTO findById(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ReviewDTO r=m.map(rS.listId(id), ReviewDTO.class);
        return r;
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PutMapping
    private void update(@RequestBody ReviewDTO dto){
        ModelMapper m=new ModelMapper();
        Review r=m.map(dto, Review.class);
        rS.modificar(r);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    private void deletebyid(@PathVariable("id") Integer id){
        rS.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/reviewProductos")
    public List<ReviewProductosDTO> ReviewdeProductos(@RequestParam Integer id){
        List<String[]> lista=rS.mostrarReviewProoductos(id);
        List<ReviewProductosDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ReviewProductosDTO dto=new ReviewProductosDTO();
            dto.setCalificacion(Integer.parseInt(columna[0]));
            dto.setComentarios(columna[1]);
            dto.setFecha(LocalDate.parse(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }


}
