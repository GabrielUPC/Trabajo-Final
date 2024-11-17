package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Role;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IRoleService;
import pe.edu.upc.trabajofinal.dtos.RoleDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@PreAuthorize("hasAuthority('ADMIN')")
public class RoleController {
    @Autowired
    private IRoleService rS;

    @PostMapping
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.insert(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rS.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(rS.listarId(id), RoleDTO.class);
        return dto;
    }

    @GetMapping
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

}
