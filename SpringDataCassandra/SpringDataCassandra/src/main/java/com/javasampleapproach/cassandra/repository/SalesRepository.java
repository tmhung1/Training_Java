package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.jpamodel.Sales;
import com.javasampleapproach.cassandra.jpamodel.SalesId;

@Repository
public interface SalesRepository extends CrudRepository<Sales, SalesId>{
	
}
