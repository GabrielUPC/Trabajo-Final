package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceInterfaces.INotificacionesInterfaces;
import pe.edu.upc.trabajofinal.dtos.NotificacionesDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {
    @Autowired
    private INotificacionesInterfaces nI;
    @GetMapping
    private List<NotificacionesDTO> listar(){
        return nI.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody NotificacionesDTO dto){
        ModelMapper m=new ModelMapper();
        Notificaciones n=m.map(dto, Notificaciones.class);
        nI.add(n);
    }
    @GetMapping("/{id}")
    public NotificacionesDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        NotificacionesDTO dto=m.map(nI.listId(id), NotificacionesDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody NotificacionesDTO dto){
        ModelMapper m=new ModelMapper();
        Notificaciones n=m.map(dto, Notificaciones.class);
        nI.modificar(n);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        nI.eliminar(id);
    }
}
