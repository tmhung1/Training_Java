package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.model.TimeCassandra;

@Repository
public interface TimeCasRepository extends CassandraRepository<TimeCassandra, UUID> {

}
