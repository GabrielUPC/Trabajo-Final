package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @Column(name="Rolename",nullable = false,length = 10)
    private String RoleName;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario u;
    public Roles() {}
    public Roles(int idRole, String RoleName) {
        this.idRole = idRole;
        this.RoleName = RoleName;
    }

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
