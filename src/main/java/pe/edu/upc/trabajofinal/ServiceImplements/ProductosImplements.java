package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.Entities.Usuario;
import pe.edu.upc.trabajofinal.Repositories.IProductos;
import pe.edu.upc.trabajofinal.Repositories.IUsuarioRepository;
import pe.edu.upc.trabajofinal.ServiceInterfaces.ProductosInterfaces;

import java.util.List;
@Service
public class ProductosImplements implements ProductosInterfaces {
    @Autowired
    private IProductos pR;
    @Autowired
    private IUsuarioRepository ur;
    @Override
    public List<Productos> list() {
        return pR.findAll();
    }

    @Override
    public void add(Productos producto) {

        if (producto.getU() != null && producto.getU().getIdUsuario() != 0) {
            Usuario usuarioPersistido = ur.findById(producto.getU().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            producto.setU(usuarioPersistido);
        } else {
            throw new RuntimeException("Usuario no especificado o ID de usuario no válido");
        }
        pR.save(producto);
    }

    @Override
    public void eliminar(int id) {
        pR.deleteById(id);
    }

    @Override
    public void modificar(Productos producto) {
        pR.save(producto);
    }

    @Override
    public Productos listid(int id) {
        return pR.findById(id).orElse(new Productos());
    }

    @Override
    public List<String[]> ProductoVencidos() {
        return pR.ProductoVencidos();
    }

    @Override
    public List<String[]> productosmasvendidos(int usuarioId) {
        return pR.productosmasvendidos(usuarioId);
    }

    @Override
    public List<String[]> ProductosConMenorStock() {
        return  pR.ProductosConMenorStock();
    }





}
