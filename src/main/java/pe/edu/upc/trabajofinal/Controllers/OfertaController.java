package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IOfertaInterface;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;
import pe.edu.upc.trabajofinal.dtos.OfertaDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class OfertaController {
    @Autowired
    private IOfertaInterface Oi;
    @GetMapping
    public List<OfertaDTO> listar() {
        return Oi.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OfertaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody OfertaDTO dto){
        ModelMapper m=new ModelMapper();
        Oferta o=m.map(dto, Oferta.class);
        Oi.add(o);
    }
    @GetMapping("/{id}")
    public OfertaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        OfertaDTO o=m.map(Oi.listId(id), OfertaDTO.class);
        return o;
    }
    @PutMapping
    public void modificar(@RequestBody OfertaDTO dto){
        ModelMapper m=new ModelMapper();
        Oferta o=m.map(dto, Oferta.class);
        Oi.modificar(o);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        Oi.eliminar(id);
    }
}
