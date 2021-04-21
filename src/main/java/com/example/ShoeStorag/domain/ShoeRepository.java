package com.example.ShoeStorag.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShoeRepository extends CrudRepository<Shoe, Long> {
	
	List<Shoe> findByName(@Param("name") String name);
	//List<Shoe> findByUser(User user);
}

