package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.MetodoPago;

import java.util.List;


public interface IMetodoPagoInterface {
    public List<MetodoPago> list();
    public void save(MetodoPago metodoPago);
    public MetodoPago listid(int id);
    public void modificar(MetodoPago metodoPago);
    public void deleteById(int id);

}
