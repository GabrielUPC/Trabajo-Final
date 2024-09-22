package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;

import pe.edu.upc.trabajofinal.ServiceInterfaces.IServicioClienteInterfaces;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteDTO;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServicioClienteController {
    @Autowired
    private IServicioClienteInterfaces Isc;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<ServicioClienteDTO> listar(){
        return Isc.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ServicioClienteDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void Insertar(@RequestBody ServicioClienteDTO sc){
        ModelMapper m=new ModelMapper();
        ServicioCliente Sc=m.map(sc, ServicioCliente.class);
        Isc.insert(Sc);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ServicioClienteDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ServicioClienteDTO dto=m.map(Isc.listId(id), ServicioClienteDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ServicioClienteDTO dto){
        ModelMapper m=new ModelMapper();
        ServicioCliente u=m.map(dto, ServicioCliente.class);
        Isc.modificar(u);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        Isc.eliminar(id);
    }
}
