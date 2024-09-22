package pe.edu.upc.trabajofinal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name="dni", nullable=false)
    private int dni;
    @Column(name = "nombre",nullable = false,length = 10)
    private String nombre;
    @Column(name = "direccion", nullable = false, length =30)
    private String direccion;
    @Column(name = "correo", nullable = false, length =30)
    private String correo;
    @Column(name = "telefono", nullable = false, length =9)
    private String telefono;
    @Column(name = "password", nullable = false, length =300)
    private String password;
    private Boolean enabled;
    @Column(name = "username", nullable = false, length =30)
    private String username;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy ="u")
    private List<Roles> roles;

    public Usuario() {
    }

    public Usuario(int idUsuario, int dni, String nombre, String direccion, String correo, String telefono, String password, Boolean enabled, String username, List<Roles> roles) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.enabled = enabled;
        this.username = username;
        this.roles = roles;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
