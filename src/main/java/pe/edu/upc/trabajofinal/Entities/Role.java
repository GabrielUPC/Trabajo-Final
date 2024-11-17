package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="rolename",nullable = false,length = 10)
    private String rolname;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    public Role() {
    }

    public Role(Long id, String rolname, Usuario user) {
        this.id = id;
        this.rolname = rolname;
        this.user = user;
    }

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
