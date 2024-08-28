package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {
    @Autowired
    private IUsuarioInterfaces uService;

    @GetMapping
    public List<UsuarioDTO> listar(){
        return uService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uService.add(u);
    }
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(uService.listId(id), UsuarioDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uService.modificar(u);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        uService.eliminar(id);
    }
}

//preguntar a la profe
