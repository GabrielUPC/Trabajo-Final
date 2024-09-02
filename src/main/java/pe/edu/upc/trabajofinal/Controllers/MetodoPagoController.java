package pe.edu.upc.trabajofinal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;
import pe.edu.upc.trabajofinal.ServiceInterfaces.IMetodoPagoInterface;
import pe.edu.upc.trabajofinal.dtos.MetodoPagoDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodo-pagos")
public class MetodoPagoController {

    @Autowired
    private IMetodoPagoInterface metodoPagoService;

    // Crear un nuevo método de pago
    @PostMapping
    public ResponseEntity<MetodoPagoDTO> createMetodoPago(@RequestBody MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = convertToEntity(metodoPagoDTO);
        MetodoPago savedMetodoPago = metodoPagoService.save(metodoPago);
        MetodoPagoDTO savedMetodoPagoDTO = convertToDTO(savedMetodoPago);
        return ResponseEntity.ok(savedMetodoPagoDTO);
    }

    // Obtener un método de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> getMetodoPagoById(@PathVariable Integer id) {
        Optional<MetodoPago> metodoPago = metodoPagoService.findById(id);
        if (metodoPago.isPresent()) {
            MetodoPagoDTO metodoPagoDTO = convertToDTO(metodoPago.get());
            return ResponseEntity.ok(metodoPagoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos los métodos de pago
    @GetMapping
    public ResponseEntity<List<MetodoPagoDTO>> getAllMetodoPagos() {
        List<MetodoPago> metodoPagos = metodoPagoService.findAll();
        List<MetodoPagoDTO> metodoPagoDTOs = metodoPagos.stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(metodoPagoDTOs);
    }

    // Actualizar un método de pago
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> updateMetodoPago(@PathVariable Integer id, @RequestBody MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = convertToEntity(metodoPagoDTO);
        metodoPago.setId(id);
        MetodoPago updatedMetodoPago = metodoPagoService.update(metodoPago);
        MetodoPagoDTO updatedMetodoPagoDTO = convertToDTO(updatedMetodoPago);
        return ResponseEntity.ok(updatedMetodoPagoDTO);
    }

    // Eliminar un método de pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer id) {
        metodoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos de conversión
    private MetodoPagoDTO convertToDTO(MetodoPago metodoPago) {
        MetodoPagoDTO dto = new MetodoPagoDTO();
        dto.setId(metodoPago.getId());
        dto.setNombre(metodoPago.getNombre());
        dto.setTipo(metodoPago.getTipo());
        //dto.setCarritoXProductoId(metodoPago.getCarritoXProductoId());
        return dto;
    }

    private MetodoPago convertToEntity(MetodoPagoDTO dto) {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setId(dto.getId());
        metodoPago.setNombre(dto.getNombre());
        metodoPago.setTipo(dto.getTipo());
        //metodoPago.setCarritoXProductoId(dto.getCarritoXProductoId());
        return metodoPago;
    }
}
