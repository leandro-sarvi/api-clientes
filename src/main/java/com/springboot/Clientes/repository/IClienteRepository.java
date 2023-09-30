package com.springboot.Clientes.repository;

import com.springboot.Clientes.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente,Long> {
}
