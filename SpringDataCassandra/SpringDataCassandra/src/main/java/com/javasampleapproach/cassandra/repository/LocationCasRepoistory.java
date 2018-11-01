package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.model.LocationCassandra;

@Repository
public interface LocationCasRepoistory extends CassandraRepository<LocationCassandra, UUID> {

}
	