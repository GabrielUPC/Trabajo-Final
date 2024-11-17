package pe.edu.upc.trabajofinal.dtos;

import pe.edu.upc.trabajofinal.Entities.Usuario;

public class RoleDTO {
    private Long id;
    private String rolname;
    private Usuario user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolname() {
        return rolname;
    }

    public void setRolname(String rolname) {
        this.rolname = rolname;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
