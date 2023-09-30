package com.springboot.Clientes.service.Implements;
import com.springboot.Clientes.entities.Cliente;
import com.springboot.Clientes.persistance.IClienteDAO;
import com.springboot.Clientes.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteDAO iClienteDAO;
    @Override
    public Optional<Cliente> findById(Long id) {
        return iClienteDAO.findById(id);
    }

    @Override
    public List<Cliente> findAll() {return iClienteDAO.findAll();}

    @Override
    public void save(Cliente cliente) {
    iClienteDAO.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        iClienteDAO.deleteById(id);
    }
}
