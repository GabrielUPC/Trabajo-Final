package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoxProductoInterfaces;
import pe.edu.upc.trabajofinal.dtos.CarritoxProductoDTO;
import pe.edu.upc.trabajofinal.dtos.CarritoxProductoUDTO;
import pe.edu.upc.trabajofinal.dtos.MetodoPagoDTO;
import pe.edu.upc.trabajofinal.dtos.ServicioClienteUDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("CarritoProductos")
public class CarritoxProductoController {
    @Autowired
    private ICarritoxProductoInterfaces Icp;
    @Autowired
    private UsuarioServicesImplements userService;
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('COMPRADOR')")
    @GetMapping
    public List<CarritoxProductoDTO>list() {
        return Icp.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoxProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @PostMapping
    public void add(@RequestBody CarritoxProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoxProducto cp=m.map(dto, CarritoxProducto.class);
        Icp.add(cp);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')" )
    @PutMapping
    public void modificar(@RequestBody CarritoxProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoxProducto cp=m.map(dto, CarritoxProducto.class);
        Icp.modificar(cp);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')" )
    @GetMapping("{id}")
    public CarritoxProductoDTO Listbyid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CarritoxProductoDTO cp=m.map(Icp.findById(id), CarritoxProductoDTO.class);
        return cp;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')" )
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        Icp.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/usuario")
    public List<CarritoxProductoUDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<CarritoxProductoUDTO> listaDTO = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            List<CarritoxProducto> carritoxProductos = Icp.list();
            ModelMapper m = new ModelMapper();
            listaDTO = carritoxProductos.stream()
                    .map(n -> m.map(n, CarritoxProductoUDTO.class))
                    .collect(Collectors.toList());
        } else {
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = Icp.findCarritosUsuarioId(userId);
            for (String[] columna : lista) {
                CarritoxProductoUDTO dto = new CarritoxProductoUDTO();
                dto.setIdCarritoXProducto(Integer.parseInt(columna[0]));
                dto.setCantidadCarrito(Integer.parseInt(columna[1]));
                listaDTO.add(dto);
            }
        }
        return listaDTO;
    }

}
