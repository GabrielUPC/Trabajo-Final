package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceImplements.UsuarioServicesImplements;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ProductosInterfaces;
import pe.edu.upc.trabajofinal.dtos.ProductosDTO;
import pe.edu.upc.trabajofinal.dtos.ProductosMVDTO;
import pe.edu.upc.trabajofinal.dtos.ProductosMenorStockDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")

public class ProductosController {
    @Autowired
    private ProductosInterfaces Ip;
    @Autowired
    private UsuarioServicesImplements userService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    public List<ProductosDTO> listar(){
        return Ip.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ProductosDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PostMapping
    public void insertar(@RequestBody ProductosDTO dto, @AuthenticationPrincipal UserDetails userDetails){
        ModelMapper m=new ModelMapper();
        Productos p = m.map(dto, Productos.class);
        int userId = userService.getUserIdFromUsername(userDetails.getUsername());
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(userId);
        p.setU(usuario);
        Ip.add(p);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/{id}")
    public ProductosDTO buscar(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ProductosDTO dto=m.map(Ip.listid(id), ProductosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PutMapping
    public void modificar(@RequestBody ProductosDTO dto){
        ModelMapper m=new ModelMapper();
        Productos p=m.map(dto, Productos.class);
        Ip.modificar(p);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id)
    {
        Ip.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/ProductosVencido")
    public List<ProductosDTO> ProductoVencido()
    {
        List<String[]>lista =Ip.ProductoVencidos();
        List<ProductosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista)
        {
            ProductosDTO dto = new ProductosDTO();
            dto.setNombreProducto(columna[0]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR') ")
    @GetMapping("/productosmenorstock")
    public List<ProductosMenorStockDTO> ProductosMenorStock(){
        List<String[]>lista=Ip.ProductosConMenorStock();
        List<ProductosMenorStockDTO> dtos=new ArrayList<>();
        for(String[] columna:lista) {
            ProductosMenorStockDTO dto=new ProductosMenorStockDTO();
            dto.setNombre((columna[0]));
            dto.setStock(Integer.parseInt(columna[1]));
            dtos.add(dto);
        }
        return dtos;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR') ")
    @GetMapping("/productosmasvendidos")
    public List<ProductosMVDTO> Productosmasvendidos(@AuthenticationPrincipal UserDetails userDetails){
        int userId = userService.getUserIdFromUsername(userDetails.getUsername());
        List<String[]>lista=Ip.productosmasvendidos(userId);
        List<ProductosMVDTO> dtos=new ArrayList<>();
        for(String[] columna:lista) {
            ProductosMVDTO dto=new ProductosMVDTO();
            dto.setNombreProducto(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtos.add(dto);
        }
        return dtos;
    }

}
