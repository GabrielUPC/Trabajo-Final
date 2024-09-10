package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoInterface;
import pe.edu.upc.trabajofinal.dtos.CarritoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Carrito")
public class CarritoController {
    @Autowired
    private ICarritoInterface cI;
    @GetMapping
    public List<CarritoDTO> listar() {
        return cI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody CarritoDTO dto){
        ModelMapper m=new ModelMapper();
        Carrito c=m.map(dto, Carrito.class);
        cI.add(c);
    }
    @GetMapping("/{id}")
    public CarritoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CarritoDTO c=m.map(cI.listId(id), CarritoDTO.class);
        return c;
    }
    @PutMapping
    public void modificar(@RequestBody CarritoDTO dto){
        ModelMapper m=new ModelMapper();
        Carrito c=m.map(dto, Carrito.class);
        cI.modificar(c);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        cI.eliminar(id);
    }
}
