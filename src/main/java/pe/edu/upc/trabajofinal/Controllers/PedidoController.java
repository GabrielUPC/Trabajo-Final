package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Pedido;
import pe.edu.upc.trabajofinal.Entities.Reclamos;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IPedidoInterface;
import pe.edu.upc.trabajofinal.dtos.MontoxPedidoDTO;
import pe.edu.upc.trabajofinal.dtos.PedidoDTO;
import pe.edu.upc.trabajofinal.dtos.PedidosUDTO;
import pe.edu.upc.trabajofinal.dtos.ReclamosUDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")

public class PedidoController {

    @Autowired
    private IPedidoInterface pI;

    @Autowired
    private UsuarioServicesImplements userService;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping
    public List<PedidoDTO> listar() {
        ModelMapper modelMapper = new ModelMapper();
        return pI.list().stream()
                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
                .collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @PostMapping
    public void add(@RequestBody PedidoDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        Pedido pedido = modelMapper.map(dto, Pedido.class);

        pI.add(pedido);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/{id}")
    public PedidoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pI.listId(id), PedidoDTO.class);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/pedidos-entre-fechas")
    public List<PedidoDTO> listarPedidosEntreFechas(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        ModelMapper modelMapper = new ModelMapper();
        return pI.findPedidosEntreFechas(fechaInicio, fechaFin).stream()
                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
                .collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @PutMapping
    public void modificar(@RequestBody PedidoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        pI.modificar(pedido);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        pI.eliminar(id);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR')")
    @GetMapping("/usuario")
    public List<PedidosUDTO> listarPorUsuarioId(@AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        List<PedidosUDTO> listaDTO = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            List<Pedido> pedidos = pI.list();
            ModelMapper m = new ModelMapper();
            listaDTO = pedidos.stream()
                    .map(n -> m.map(n, PedidosUDTO.class))
                    .collect(Collectors.toList());
        } else {
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = pI.findPedidosByUsuarioId(userId);
            for (String[] columna : lista) {
                PedidosUDTO dto = new PedidosUDTO();
                dto.setIdPedido(Integer.parseInt(columna[0]));
                dto.setEstado(columna[1]);
                dto.setFechacPedido(LocalDate.parse(columna[2]));
                dto.setFechaEntrega(LocalDate.parse(columna[3]));
                listaDTO.add(dto);
            }
        }
        return listaDTO;
    }
    @PreAuthorize("hasAuthority('VENDEDOR') or hasAuthority('ADMIN')")
    @GetMapping("/vendedor")
    public List<PedidosUDTO> findPedidosVendedor(@AuthenticationPrincipal UserDetails userDetails) {

        List<PedidosUDTO> listaDTO = new ArrayList<>();

            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = pI.findPedidosVendedor(userId);
            for (String[] columna : lista) {
                PedidosUDTO dto = new PedidosUDTO();
                dto.setIdPedido(Integer.parseInt(columna[0]));
                dto.setEstado(columna[1]);
                dto.setFechacPedido(LocalDate.parse(columna[2]));
                dto.setFechaEntrega(LocalDate.parse(columna[3]));
                listaDTO.add(dto);
            }

        return listaDTO;
    }
    @PreAuthorize("hasAuthority('VENDEDOR') or hasAuthority('ADMIN')")
    @GetMapping("/montopedido")
    public List<MontoxPedidoDTO> MontoxPedido(@AuthenticationPrincipal UserDetails userDetails) {
        List<MontoxPedidoDTO> listaDTO = new ArrayList<>();
            int userId = userService.getUserIdFromUsername(userDetails.getUsername());
            List<String[]> lista = pI.MontoxPedido(userId);
            for (String[] columna : lista) {
                MontoxPedidoDTO dto = new MontoxPedidoDTO();
                dto.setId_pedido(Integer.parseInt(columna[0]));
                dto.setMontototal(Double.parseDouble(columna[1]));
                listaDTO.add(dto);
            }

        return listaDTO;
    }
}
