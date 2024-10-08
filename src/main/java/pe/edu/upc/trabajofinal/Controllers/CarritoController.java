package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ICarritoInterface;
import pe.edu.upc.trabajofinal.dtos.CarritoDTO;
import pe.edu.upc.trabajofinal.dtos.GastoUsuarioFechaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Carrito")
public class CarritoController {
    @Autowired
    public ICarritoInterface cI;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<CarritoDTO> listar() {
        return cI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PostMapping
    public void add(@RequestBody CarritoDTO dto){
        ModelMapper m=new ModelMapper();
        Carrito c=m.map(dto, Carrito.class);
        cI.add(c);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public CarritoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CarritoDTO c=m.map(cI.listId(id), CarritoDTO.class);
        return c;
    }

    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody CarritoDTO dto){
        ModelMapper m=new ModelMapper();
        Carrito c=m.map(dto, Carrito.class);
        cI.modificar(c);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        cI.eliminar(id);
    }
    @PreAuthorize("hasAuthority('COMPRADOR') or hasAuthority('ADMIN')")
    @GetMapping("/gastousuariomes")
    public List<GastoUsuarioFechaDTO> gastousuariomes(){
        List<String[]>lista=cI.gastototalusuariopormesService();
        List<GastoUsuarioFechaDTO> dtos=new ArrayList<>();
        for(String[] columna:lista) {
            GastoUsuarioFechaDTO dto=new GastoUsuarioFechaDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setPrecioTotalCarrito(Double.parseDouble(columna[1]));
            dtos.add(dto);
        }
        return dtos;
    }
}
