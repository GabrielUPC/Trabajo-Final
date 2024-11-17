package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Reclamos;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IReclamosInterface;
import pe.edu.upc.trabajofinal.dtos.ReclamosDTO;
import pe.edu.upc.trabajofinal.dtos.ReclamosUDTO;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteUDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
public class ReclamosController {
    @Autowired
    private IReclamosInterface rI;
    @Autowired
    private UsuarioServicesImplements userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    private List<ReclamosDTO> listar(){
        return rI.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ReclamosDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody ReclamosDTO dto){
        ModelMapper m=new ModelMapper();
        Reclamos r = m.map(dto, Reclamos.class);

        rI.add(r);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ReclamosDTO listarporid(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ReclamosDTO dto=m.map(rI.listId(id), ReclamosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ReclamosDTO dto){
        ModelMapper m=new ModelMapper();
        Reclamos r=m.map(dto, Reclamos.class);
        rI.modificar(r);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id)
    {
        rI.eliminar(id);
    }
    @GetMapping("/usuario")
    public List<ReclamosUDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<ReclamosUDTO> listaDTO = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            List<Reclamos> reclamos = rI.list();
            ModelMapper m = new ModelMapper();
            listaDTO = reclamos.stream()
                    .map(n -> m.map(n, ReclamosUDTO.class))
                    .collect(Collectors.toList());
        } else {
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = rI.findReclamosByUsuarioId(userId);
            for (String[] columna : lista) {
                ReclamosUDTO dto = new ReclamosUDTO();
                dto.setIdReclamos(Integer.parseInt(columna[0]));
                dto.setContenidoReclamo(columna[1]);
                dto.setFechaReclamo(LocalDate.parse(columna[2]));
                listaDTO.add(dto);
            }
        }
        return listaDTO;
    }
    @PreAuthorize("hasAuthority('VENDEDOR') or hasAuthority('ADMIN')")
    @GetMapping("/vendedor")
    public List<ReclamosUDTO> findReclamosalVendedor(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<ReclamosUDTO> listaDTO = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            List<Reclamos> reclamos = rI.list();
            ModelMapper m = new ModelMapper();
            listaDTO = reclamos.stream()
                    .map(n -> m.map(n, ReclamosUDTO.class))
                    .collect(Collectors.toList());
        } else {
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = rI.findReclamosalVendedor(userId);
            for (String[] columna : lista) {
                ReclamosUDTO dto = new ReclamosUDTO();
                dto.setIdReclamos(Integer.parseInt(columna[0]));
                dto.setContenidoReclamo(columna[1]);
                dto.setFechaReclamo(LocalDate.parse(columna[2]));
                listaDTO.add(dto);
            }
        }
        return listaDTO;
    }
}
