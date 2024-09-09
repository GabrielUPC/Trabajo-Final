package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Roles;
import pe.edu.upc.trabajofinal.Repositories.IRolesRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IRolesInterfaces;

import java.util.List;
@Service
public class RolesImplements implements IRolesInterfaces
{
    @Autowired
    private IRolesRepository rR;
    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Roles role) {
        rR.save(role);
    }

    @Override
    public Roles ListbyId(int id) {
        return rR.findById(id).orElse(new Roles());
    }

    @Override
    public void modificar(Roles role) {
        rR.save(role);
    }

    @Override
    public void eliminar(int id) {
        rR.deleteById(id);
    }


}
