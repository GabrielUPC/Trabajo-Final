package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IServicioClienteInterfaces;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
@PreAuthorize("hasAuthority('ADMIN')")
public class ServicioClienteController {
    @Autowired
    private IServicioClienteInterfaces Isc;

    @GetMapping
    private List<ServicioClienteDTO> listar(){
        return Isc.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ServicioClienteDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    private void Insertar(@RequestBody ServicioClienteDTO sc){
        ModelMapper m=new ModelMapper();
        ServicioCliente Sc=m.map(sc, ServicioCliente.class);
        Isc.insert(Sc);
    }

    @GetMapping("/{id}")
    public ServicioClienteDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ServicioClienteDTO dto=m.map(Isc.listId(id), ServicioClienteDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ServicioClienteDTO dto){
        ModelMapper m=new ModelMapper();
        ServicioCliente u=m.map(dto, ServicioCliente.class);
        Isc.modificar(u);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        Isc.eliminar(id);
    }
}
