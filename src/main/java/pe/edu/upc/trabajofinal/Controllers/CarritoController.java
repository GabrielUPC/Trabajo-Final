package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoInterfaces;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoxProductoInterfaces;
import pe.edu.upc.trabajofinal.dtos.CarritoDTO;
import pe.edu.upc.trabajofinal.dtos.CarritoUDTO;
import pe.edu.upc.trabajofinal.dtos.CarritoxProductoDTO;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteUDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("carritos")

public class CarritoController {
    @Autowired
    private ICarritoInterfaces Ic;
    @Autowired
    private UsuarioServicesImplements userService;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping
    public List<CarritoDTO> list() {
        return Ic.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PostMapping
    public void add(@RequestBody CarritoDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        ModelMapper m = new ModelMapper();
        Carrito cp=m.map(dto, Carrito.class);
        int userId = userService.getUserIdFromUsername(userDetails.getUsername());
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(userId);
        cp.setU(usuario);
        Ic.add(cp);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody CarritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Carrito cp=m.map(dto, Carrito.class);
        Ic.modificar(cp);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public CarritoDTO Listbyid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CarritoDTO cp=m.map(Ic.findById(id), CarritoDTO.class);
        return cp;
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        Ic.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/usuario")
    public List<CarritoUDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<CarritoUDTO> listaDTO = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            List<Carrito> carritos = Ic.list();
            ModelMapper m = new ModelMapper();
            listaDTO = carritos.stream()
                    .map(n -> m.map(n, CarritoUDTO.class))
                    .collect(Collectors.toList());
        } else {
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = Ic.findCarritosByUsuarioId(userId);
            for (String[] columna : lista) {
                CarritoUDTO dto = new CarritoUDTO();
                dto.setId(Integer.parseInt(columna[0]));
                listaDTO.add(dto);
            }
        }
        return listaDTO;
    }
}
