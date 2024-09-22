package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ProductosInterfaces;
import pe.edu.upc.trabajofinal.dtos.ProductoEnOfeta;
import pe.edu.upc.trabajofinal.dtos.ProductosDTO;
import pe.edu.upc.trabajofinal.dtos.ReviewDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")

public class ProductosController {
    @Autowired
    private ProductosInterfaces Ip;
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
    public void insertar(@RequestBody ProductosDTO dto){
        ModelMapper m=new ModelMapper();
        Productos p = m.map(dto, Productos.class);
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
    @GetMapping("/ProductosEnOferta")
    public List<ProductoEnOfeta> ProductoEnOfeta()
    {
        List<String[]>lista =Ip.ProductoEnOfeta();
        List<ProductoEnOfeta> listaDTO = new ArrayList<>();
        for (String[] columna : lista)
        {
            ProductoEnOfeta dto = new ProductoEnOfeta();
            dto.setProducto(columna[0]);
            dto.setNombreOfeta(columna[1]);
            dto.setFechaInicial(LocalDate.parse(columna[2]));
            dto.setFechaFinal(LocalDate.parse(columna[3]));
            dto.setCantidadProducto(Integer.parseInt(columna[4]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/obtenerreseñasporProducto")
    public List<ReviewDTO> ObtenerResenasProducto(@RequestParam String nombreProducto) {
        List<String[]>lista = Ip.ObtenerResenasProducto(nombreProducto);
        List<ReviewDTO>listaDTO= new ArrayList<>();
        for (String[]columna : lista)
        {
            ReviewDTO dto= new ReviewDTO();
            dto.setCalificacion(Integer.parseInt(columna[0]));
            dto.setComentarios(columna[1]);
            dto.setFecha(LocalDate.parse(columna[2]));
            listaDTO.add(dto);
        }
         return listaDTO;
    }
}
