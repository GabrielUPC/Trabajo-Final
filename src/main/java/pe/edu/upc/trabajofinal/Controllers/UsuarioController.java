package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UsuarioDTO> listar(){
        return uService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void add(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uService.add(u);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR') or hasAuthority('COMPRADOR')")
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(uService.listId(id), UsuarioDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uService.modificar(u);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        uService.eliminar(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
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
