package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Roles;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IRolesInterfaces;
import pe.edu.upc.trabajofinal.dtos.RolesDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Roles")
public class RolesController {
    @Autowired
    private IRolesInterfaces rI;
    @GetMapping
    private List<RolesDTO> listRoles() {
        return rI.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    private void Insertar(@RequestBody RolesDTO dto) {
        ModelMapper m=new ModelMapper();
        Roles r=m.map(dto, Roles.class);
        rI.insert(r);
    }
    @PutMapping
    private void modificar(@RequestBody RolesDTO dto) {
        ModelMapper m=new ModelMapper();
        Roles r=m.map(dto, Roles.class);
        rI.modificar(r);
    }
    @GetMapping("/{id}")
    private RolesDTO listarporid(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RolesDTO dto=m.map(rI.ListbyId(id), RolesDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    private void eliminar(@PathVariable("id") Integer id) {
        rI.eliminar(id);
    }
}
