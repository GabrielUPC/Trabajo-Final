package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.INotificacionesInterfaces;
import pe.edu.upc.trabajofinal.dtos.NotificacionIDDTO;
import pe.edu.upc.trabajofinal.dtos.NotificacionesDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private INotificacionesInterfaces nI;

    @Autowired
    private UsuarioServicesImplements userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<NotificacionesDTO> listar() {
        return nI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void add(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        nI.add(n);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public NotificacionesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        NotificacionesDTO dto = m.map(nI.listId(id), NotificacionesDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        nI.modificar(n);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        nI.eliminar(id);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR') or hasAuthority('COMPRADOR')")
    @GetMapping("/usuario")
    public List<NotificacionIDDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
       //aqui se obtiene el rol del usuario autenticaso
        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        List<NotificacionIDDTO> listaDTO = new ArrayList<>();
//admin
        if ("ADMIN".equals(role)) {
            List<Notificaciones> notificaciones = nI.list();
            ModelMapper m = new ModelMapper();
            listaDTO = notificaciones.stream()
                    .map(n -> m.map(n, NotificacionIDDTO.class))
                    .collect(Collectors.toList());
        } else {
           //otro rol
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = nI.buscarIDUS(userId);
            for (String[] columna : lista) {
                NotificacionIDDTO dto = new NotificacionIDDTO();
                dto.setIdNotificacion(Integer.parseInt(columna[0]));
                dto.setContenido(columna[1]);
                dto.setFecha(LocalDate.parse(columna[2]));
                listaDTO.add(dto);
            }
        }

        return listaDTO;
    }
}
