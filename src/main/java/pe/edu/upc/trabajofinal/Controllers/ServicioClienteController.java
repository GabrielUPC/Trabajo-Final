package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;

import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IServicioClienteInterfaces;
import pe.edu.upc.trabajofinal.dtos.NotificacionIDDTO;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteDTO;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteUDTO;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")

public class ServicioClienteController {
    @Autowired
    private IServicioClienteInterfaces Isc;
    @Autowired
    private UsuarioServicesImplements userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<ServicioClienteDTO> listar(){
        return Isc.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ServicioClienteDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @PostMapping
    public void add(@RequestBody ServicioClienteDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        ModelMapper m = new ModelMapper();
        ServicioCliente sc = m.map(dto, ServicioCliente.class);
        int userId = userService.getUserIdFromUsername(userDetails.getUsername());
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(userId);
        sc.setU(usuario);
        Isc.insert(sc);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/{id}")
    public ServicioClienteDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ServicioClienteDTO dto=m.map(Isc.listId(id), ServicioClienteDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @PutMapping
    public void modificar(@RequestBody ServicioClienteDTO dto){
        ModelMapper m=new ModelMapper();
        ServicioCliente u=m.map(dto, ServicioCliente.class);
        Isc.modificar(u);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        Isc.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/usuario")
    public List<ServicioClienteUDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<ServicioClienteUDTO> listaDTO = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            List<ServicioCliente> servicioClientes = Isc.list();
            ModelMapper m = new ModelMapper();
            listaDTO = servicioClientes.stream()
                    .map(n -> m.map(n, ServicioClienteUDTO.class))
                    .collect(Collectors.toList());
        } else {
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = Isc.findServiciosByUsuarioId(userId);
            for (String[] columna : lista) {
                ServicioClienteUDTO dto = new ServicioClienteUDTO();
                dto.setId(Integer.parseInt(columna[0]));
                dto.setDescripcion(columna[1]);
                dto.setFechaservicio(LocalDate.parse(columna[2]));
                dto.setNombre(columna[3]);
                listaDTO.add(dto);
            }
        }
        return listaDTO;
    }
}
