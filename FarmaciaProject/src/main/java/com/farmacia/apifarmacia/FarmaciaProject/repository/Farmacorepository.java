package com.farmacia.apifarmacia.FarmaciaProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.farmacia.apifarmacia.FarmaciaProject.entidies.Farmaco;

@Repository
public interface Farmacorepository extends CrudRepository<Farmaco, Long>{

}
