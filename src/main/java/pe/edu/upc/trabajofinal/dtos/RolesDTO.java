package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.*;
import pe.edu.upc.trabajofinal.Entities.Usuario;

public class RolesDTO {

    private int idRole;

    private String RoleName;

    private Usuario u;


    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }
}
