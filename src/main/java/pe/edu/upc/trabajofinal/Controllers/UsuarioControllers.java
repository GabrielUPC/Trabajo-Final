package pe.edu.upc.trabajofinal.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.trabajofinal.dtos.UsuarioDTO;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IUsuarioInterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {
    @Autowired
    private IUsuarioInterfaces uService;

    @GetMapping
    public List<UsuarioDTO> listar(){
        return uService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}

//preguntar a la profe
