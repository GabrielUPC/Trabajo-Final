package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ProductosInterfaces;
import pe.edu.upc.trabajofinal.dtos.GananciaTotalPorTiendaDTO;
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
    private List<ProductosDTO> listar(){
        return Ip.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ProductosDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PostMapping
    private void insertar(@RequestBody ProductosDTO dto){
        ModelMapper m=new ModelMapper();
        Productos p = m.map(dto, Productos.class);
        Ip.add(p);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/{id}")
    private ProductosDTO buscar(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ProductosDTO dto=m.map(Ip.listid(id), ProductosDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PutMapping
    private void modificar(@RequestBody ProductosDTO dto){
        ModelMapper m=new ModelMapper();
        Productos p=m.map(dto, Productos.class);
        Ip.modificar(p);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @DeleteMapping("/{id}")
    private void eliminar(@PathVariable("id") Integer id)
    {
        Ip.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/ProductosVencido")
        private List<ProductosDTO> ProductoVencido()
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
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/GananciasPorTiendas")
    public  List<GananciaTotalPorTiendaDTO> GananciasPorTiendas(){
        List<String[]>lista = Ip.GananciaTotalPorTienda();
        List<GananciaTotalPorTiendaDTO>listaDTO= new ArrayList<>();
        for (String[]columna : lista)
        {
            GananciaTotalPorTiendaDTO dto= new GananciaTotalPorTiendaDTO();
            dto.setTienda(columna[0]);
            dto.setGananciaTotal(Double.parseDouble(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
