package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.Entities.Pedido;
import pe.edu.upc.trabajofinal.ServiceInterfaces.INotificacionesInterfaces;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IPedidoInterface;
import pe.edu.upc.trabajofinal.dtos.NotificacionesDTO;
import pe.edu.upc.trabajofinal.dtos.PedidoDTO;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Pedido")
public class PedidoController {
    @Autowired
    private IPedidoInterface pI;
    @GetMapping
    private List<PedidoDTO> listar(){
        return pI.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, PedidoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody PedidoDTO dto){
        ModelMapper m=new ModelMapper();
        Pedido p=m.map(dto, Pedido.class);
        pI.add(p);
    }
    @GetMapping("/{id}")
    public PedidoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        PedidoDTO dto=m.map(pI.listId(id), PedidoDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody PedidoDTO dto){
        ModelMapper m=new ModelMapper();
        Pedido n=m.map(dto, Pedido.class);
        pI.modificar(n);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        pI.eliminar(id);
    }
}
