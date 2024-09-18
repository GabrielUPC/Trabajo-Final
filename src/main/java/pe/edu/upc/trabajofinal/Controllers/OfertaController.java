package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IOfertaInterface;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;
import pe.edu.upc.trabajofinal.dtos.OfertaDTO;
import pe.edu.upc.trabajofinal.dtos.ReporteOfertaActivas;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {
    @Autowired
    private IOfertaInterface Oi;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping
    public List<OfertaDTO> listar() {
        return Oi.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OfertaDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PostMapping
    public void add(@RequestBody OfertaDTO dto){
        ModelMapper m=new ModelMapper();
        Oferta o=m.map(dto, Oferta.class);
        Oi.add(o);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @GetMapping("/{id}")
    public OfertaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        OfertaDTO o=m.map(Oi.listId(id), OfertaDTO.class);
        return o;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @PutMapping
    public void modificar(@RequestBody OfertaDTO dto){
        ModelMapper m=new ModelMapper();
        Oferta o=m.map(dto, Oferta.class);
        Oi.modificar(o);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        Oi.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('COMPRADOR') or hasAuthority('VENDEDOR')")
    @GetMapping("/ofertasactivas")
    public List<ReporteOfertaActivas> ofertaActivas(){
        List<String[]> lista=Oi.ofertasactivas();
        List<ReporteOfertaActivas> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ReporteOfertaActivas dto=new ReporteOfertaActivas();
            dto.setNombreOferta(columna[0]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
