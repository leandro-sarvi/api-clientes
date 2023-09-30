package com.springboot.Clientes.persistance;

import com.springboot.Clientes.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDAO {
    Optional<Cliente> findById (Long id);
    List<Cliente> findAll();
    void save(Cliente cliente);
    void deleteById(Long id);
}
