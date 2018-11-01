package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.model.ProductCassandra;



@Repository
public interface ProductCasRepository extends CassandraRepository<ProductCassandra,UUID>  {
	 ProductCassandra findOneByProductId (UUID product_id);
	
}
