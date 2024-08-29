package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.trabajofinal.Entities.Tiendas;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ITiendaInterfaces;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;
import pe.edu.upc.trabajofinal.dtos.TiendaDTO;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendaControllers {
    @Autowired
    private ITiendaInterfaces tService;

    @GetMapping
    public List<TiendaDTO> listar(){
        return tService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TiendaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody TiendaDTO dto){
        ModelMapper m=new ModelMapper();
        Tiendas t=m.map(dto, Tiendas.class);
        tService.add(t);
    }
    @GetMapping("/{id}")
    public TiendaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        TiendaDTO dto=m.map(tService.listId(id), TiendaDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody TiendaDTO dto){
        ModelMapper m=new ModelMapper();
        Tiendas u=m.map(dto, Tiendas.class);
        tService.modificar(u);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        tService.eliminar(id);
    }
}
