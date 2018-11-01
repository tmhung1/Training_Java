package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.model.SalesCassandra;

@Repository
public interface SalesCasRepository extends CassandraRepository<SalesCassandra, UUID> {

}
