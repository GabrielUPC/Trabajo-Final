package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IMetodoPagoInterface;
import pe.edu.upc.trabajofinal.dtos.MetodoPagoDTO;


import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodo-pagos")
public class MetodoPagoController {

    @Autowired
    private IMetodoPagoInterface mP;
    @PreAuthorize("hasRole('ADMIN')")
    // Crear un nuevo método de pago
    @PostMapping
    public void insertar(@RequestBody MetodoPagoDTO dto){
        ModelMapper m=new ModelMapper();
        MetodoPago mp=m.map(dto,MetodoPago.class);
        mP.save(mp);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping()
    public List<MetodoPagoDTO> list() {
        return mP.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/findMetodoPagoByTipo")
    public List<MetodoPagoDTO> findMetodoPagoByTipo(@RequestParam String tipo) {
        return mP.findMetodoPagoByTipo(tipo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/{id}")
    public MetodoPagoDTO ordenarbyid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO dto=m.map(mP.listid(id),MetodoPagoDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMIN') ")
    @PutMapping
    public void modificar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago d=m.map(dto,MetodoPago.class);
        mP.modificar(d);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mP.deleteById(id);
    }
}
