package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoxProductoInterfaces;
import pe.edu.upc.trabajofinal.dtos.CarritoxProductoDTO;
import pe.edu.upc.trabajofinal.dtos.MetodoPagoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("CarritoProductos")
public class CarritoxProductoController {
    @Autowired
    private ICarritoxProductoInterfaces Icp;
    @GetMapping
    private List<CarritoxProductoDTO>list() {
        return Icp.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoxProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    private void add(@RequestBody CarritoxProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoxProducto cp=m.map(dto, CarritoxProducto.class);
        Icp.add(cp);
    }
    @PutMapping
    private void modificar(@RequestBody CarritoxProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoxProducto cp=m.map(dto, CarritoxProducto.class);
        Icp.modificar(cp);
    }
    @GetMapping("{id}")
    private CarritoxProductoDTO Listbyid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CarritoxProductoDTO cp=m.map(Icp.findById(id), CarritoxProductoDTO.class);
        return cp;
    }
    @DeleteMapping("{id}")
    private void eliminar(@PathVariable("id") Integer id) {
        Icp.eliminar(id);
    }
    @GetMapping("/montoTotal/{idCarrito}")

    public Double calcularMontoTotal(@PathVariable("idCarrito") int idCarrito) {
        return Icp.calcularMontoTotal(idCarrito);
    }
}
