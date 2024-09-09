package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Roles;

import java.util.List;

public interface IRolesInterfaces {
    public List<Roles> list();
    public void insert(Roles role);
    public Roles ListbyId(int id);
    public void modificar(Roles role);
    public void eliminar(int id);
}
