package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Reclamos;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IReclamosInterface;
import pe.edu.upc.trabajofinal.dtos.ReclamosDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
public class ReclamosController {
    @Autowired
    private IReclamosInterface rI;
    @GetMapping
    private List<ReclamosDTO> listar(){
        return rI.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ReclamosDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    private void insertar(@RequestBody ReclamosDTO dto){
        ModelMapper m=new ModelMapper();
        Reclamos r = m.map(dto, Reclamos.class);
        rI.add(r);
    }
    @GetMapping("/{id}")
    private ReclamosDTO listarporid(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ReclamosDTO dto=m.map(rI.listId(id), ReclamosDTO.class);
        return dto;
    }
    @PutMapping
    private void modificar(@RequestBody ReclamosDTO dto){
        ModelMapper m=new ModelMapper();
        Reclamos r=m.map(dto, Reclamos.class);
        rI.modificar(r);
    }
    @DeleteMapping("/{id}")
    private void eliminar(@PathVariable("id") Integer id)
    {
        rI.eliminar(id);
    }
}
