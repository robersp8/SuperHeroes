package com.robertorsp.crud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertorsp.crud.entities.SuperHeroe;

@Repository
public interface SuperHeroeRepository extends CrudRepository<SuperHeroe, Long> {

	List<SuperHeroe> findByName(String name);

}
