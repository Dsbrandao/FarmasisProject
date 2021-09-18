package com.farmacia.apifarmacia.FarmaciaProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.farmacia.apifarmacia.FarmaciaProject.entidies.Cliente;

@Repository
public interface Clienterepository extends CrudRepository<Cliente, Long> {

}
