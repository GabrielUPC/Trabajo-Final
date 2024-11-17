package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IOfertaInterface;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;
import pe.edu.upc.trabajofinal.dtos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {
    @Autowired
    public IOfertaInterface Oi;
    @Autowired
    private UsuarioServicesImplements userService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping
    public List<OfertaDTO> listar() {
        return Oi.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OfertaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PostMapping
    public void add(@RequestBody OfertaDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        ModelMapper m = new ModelMapper();
        Oferta o = m.map(dto, Oferta.class);
        int userId = userService.getUserIdFromUsername(userDetails.getUsername());
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(userId);
        o.setU(usuario);
        Oi.add(o);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @GetMapping("/{id}")
    public OfertaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        OfertaDTO o = m.map(Oi.listId(id), OfertaDTO.class);
        return o;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PutMapping
    public void modificar(@RequestBody OfertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Oferta o = m.map(dto, Oferta.class);

        Oi.modificar(o);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        Oi.eliminar(id);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')or hasAuthority('COMPRADOR')")
    @GetMapping("/usuario")
    public List<OfertaUDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<OfertaUDTO> listaDTO = new ArrayList<>();

            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = Oi.findOfertasByUsuarioId(userId);
            for (String[] columna : lista) {
                OfertaUDTO dto = new OfertaUDTO();
                dto.setIdOferta(Integer.parseInt(columna[0]));
                dto.setNombreOferta(columna[1]);
                dto.setFechaInicio(LocalDate.parse(columna[2]));
                dto.setFechaFin(LocalDate.parse(columna[3]));
                dto.setCantidad(Integer.parseInt(columna[4]));
                listaDTO.add(dto);
            }

        return listaDTO;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/ofertasactivas")
    public List<OfertaUDTO> ofertasactivas() {
        List<OfertaUDTO> listaDTO = new ArrayList<>();
            List<String[]> lista = Oi.ofertasactivas();
            for (String[] columna : lista) {
                OfertaUDTO dto = new OfertaUDTO();
                dto.setIdOferta(Integer.parseInt(columna[0]));
                dto.setNombreOferta(columna[1]);
                dto.setFechaInicio(LocalDate.parse(columna[2]));
                dto.setFechaFin(LocalDate.parse(columna[3]));
                dto.setCantidad(Integer.parseInt(columna[4]));
                listaDTO.add(dto);
            }

        return listaDTO;
    }
}
