package com.springboot.Clientes.Controllers;
import com.springboot.Clientes.dto.ClienteDTO;
import com.springboot.Clientes.entities.Cliente;
import com.springboot.Clientes.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class ClientesController {
    @Autowired
    private IClienteService clienteService;
@GetMapping("/cliente/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Cliente cliente = clienteService.findById(id)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente no encontrado o inexistente"));
            ClienteDTO clienteDTO = ClienteDTO.builder()
                    .id_cliente(cliente.getId_cliente())
                    .nombre_cliente(cliente.getNombre_cliente())
                    .apellido_cliente(cliente.getApellido_cliente())
                    .correo_cliente(cliente.getCorreo_cliente())
                    .fecha_registro(cliente.getFecha_registro())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(clienteDTO);

        }catch (ResponseStatusException e){
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getReason());
        }
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<ClienteDTO> clienteList = clienteService.findAll().stream()
                .map(cliente-> ClienteDTO.builder()
                        .id_cliente(cliente.getId_cliente())
                        .nombre_cliente(cliente.getNombre_cliente())
                        .apellido_cliente(cliente.getApellido_cliente())
                        .correo_cliente(cliente.getCorreo_cliente())
                        .fecha_registro(cliente.getFecha_registro())
                        .build()
                ).toList();
        return ResponseEntity.status(HttpStatus.OK).body(clienteList);
    }
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try {
            clienteService.findById(id)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado o no existe"));
            clienteService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente eliminado correctamente!!!");
        }catch (ResponseStatusException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getReason());
        }
    }
    @PostMapping("/cliente")
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO){
        if(clienteDTO ==null || clienteDTO.getNombre_cliente().isBlank() ||
                clienteDTO.getApellido_cliente().isBlank() || clienteDTO.getCorreo_cliente().isBlank() ||
                clienteDTO.getFecha_registro() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campos vacios");
        }
        Cliente cliente = Cliente.builder()
                .id_cliente(clienteDTO.getId_cliente())
                .nombre_cliente(clienteDTO.getNombre_cliente())
                .apellido_cliente(clienteDTO.getApellido_cliente())
                .correo_cliente(clienteDTO.getCorreo_cliente())
                .fecha_registro(clienteDTO.getFecha_registro())
                .build();
        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente ingresado correctamente");
    }
    @PutMapping("/cliente/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id){
    try{
        Cliente clienteOptional = clienteService.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado o inexistente"));
        Cliente cliente = Cliente.builder()
                .id_cliente(clienteOptional.getId_cliente())
                .nombre_cliente(clienteOptional.getNombre_cliente())
                .apellido_cliente(clienteOptional.getApellido_cliente())
                .correo_cliente(clienteOptional.getCorreo_cliente())
                .fecha_registro(clienteOptional.getFecha_registro())
                .build();
        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente editado correctamente");
    }catch (ResponseStatusException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getReason());
    }
    }
    /* *minuto 2:27*/
}
