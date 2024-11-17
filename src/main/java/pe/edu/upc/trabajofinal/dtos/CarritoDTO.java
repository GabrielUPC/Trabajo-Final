package pe.edu.upc.trabajofinal.dtos;


import pe.edu.upc.trabajofinal.Entities.Usuario;

public class CarritoDTO {
    private int id;
    private Usuario u;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
}
