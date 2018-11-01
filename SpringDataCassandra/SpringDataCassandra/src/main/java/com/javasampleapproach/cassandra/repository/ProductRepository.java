package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.jpamodel.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
	
	// Product findOneByProduct_id(UUID product_id);
}
