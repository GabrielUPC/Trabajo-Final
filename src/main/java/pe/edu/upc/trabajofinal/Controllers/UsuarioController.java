package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;
import pe.edu.upc.trabajofinal.dtos.UsuarioReclamoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioInterfaces uService;

    @GetMapping
    public List<UsuarioDTO> listar(){
        return uService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void add(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uService.add(u);
    }
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(uService.listId(id), UsuarioDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uService.modificar(u);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        uService.eliminar(id);
    }
    @GetMapping("/usuariosReclamos")
    public List<UsuarioReclamoDTO> UsuarioReclamo(){
        List<String[]> lista = uService.UsuarioReclamo();
        List<UsuarioReclamoDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista)
        {
            UsuarioReclamoDTO dto= new UsuarioReclamoDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setContenidoReclamo(columna[1]);
            dto.setFechaReclamo(LocalDate.parse(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
