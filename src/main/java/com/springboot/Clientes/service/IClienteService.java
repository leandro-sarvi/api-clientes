package com.springboot.Clientes.service;

import com.springboot.Clientes.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    Optional<Cliente> findById (Long id);
    List<Cliente> findAll();
    void save(Cliente cliente);
    void deleteById(Long id);

}
