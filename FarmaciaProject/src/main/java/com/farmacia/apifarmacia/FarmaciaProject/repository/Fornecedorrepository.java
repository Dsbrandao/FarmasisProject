package com.farmacia.apifarmacia.FarmaciaProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.farmacia.apifarmacia.FarmaciaProject.entidies.Fornecedor;

@Repository
public interface Fornecedorrepository extends CrudRepository<Fornecedor, Long> {

}
