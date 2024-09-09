package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.CarritoXProducto;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoXProductoInterface;
import pe.edu.upc.trabajofinal.dtos.CarritoXProductoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/CarritoXProducto")

public class CarritoXProductoController {

        @Autowired
        private ICarritoXProductoInterface cxP;
        @GetMapping
        public List<CarritoXProductoDTO> listar() {
            return cxP.list().stream().map(x -> {
                ModelMapper m = new ModelMapper();
                return m.map(x, CarritoXProductoDTO.class);
            }).collect(Collectors.toList());
        }
        @PostMapping
        public void add(@RequestBody CarritoXProductoDTO dto){
            ModelMapper m=new ModelMapper();
            CarritoXProducto c=m.map(dto, CarritoXProducto.class);
            cxP.add(c);
        }
        @GetMapping("/{id}")
        public CarritoXProductoDTO listarId(@PathVariable("id") Integer id){
            ModelMapper m=new ModelMapper();
            CarritoXProductoDTO c=m.map(cxP.listId(id), CarritoXProductoDTO.class);
            return c;
        }
        @PutMapping
        public void modificar(@RequestBody CarritoXProductoDTO dto){
            ModelMapper m=new ModelMapper();
            CarritoXProducto c=m.map(dto, CarritoXProducto.class);
            cxP.modificar(c);
        }
        @DeleteMapping("{id}")
        public void delete(@PathVariable("id") Integer id){
            cxP.eliminar(id);
        }

    }

