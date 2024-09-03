package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ProductosInterfaces;
import pe.edu.upc.trabajofinal.dtos.ProductosDTO;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosInterfaces Ip;
    @GetMapping
    private List<ProductosDTO> listar(){
        return Ip.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ProductosDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    private void insertar(@RequestBody ProductosDTO dto){
        ModelMapper m=new ModelMapper();
        Productos p = m.map(dto, Productos.class);
        Ip.add(p);
    }
    @GetMapping("/{id}")
    private ProductosDTO buscar(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ProductosDTO dto=m.map(Ip.listid(id), ProductosDTO.class);
        return dto;
    }
    @PutMapping
    private void modificar(@RequestBody ProductosDTO dto){
        ModelMapper m=new ModelMapper();
        Productos p=m.map(dto, Productos.class);
        Ip.modificar(p);
    }
    @DeleteMapping("/{id}")
    private void eliminar(@PathVariable("id") Integer id)
    {
        Ip.eliminar(id);
    }
}
