package com.springboot.Clientes.persistance.impl;

import com.springboot.Clientes.entities.Cliente;
import com.springboot.Clientes.persistance.IClienteDAO;
import com.springboot.Clientes.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteDAOImpl implements IClienteDAO {
    @Autowired
    IClienteRepository iClienteRepository;
    @Override
    public Optional<Cliente> findById(Long id) {
        return iClienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteRepository.findAll();
    }

    @Override
    public void save(Cliente cliente) {iClienteRepository.save(cliente);}

    @Override
    public void deleteById(Long id) {
    iClienteRepository.deleteById(id);
    }
}
