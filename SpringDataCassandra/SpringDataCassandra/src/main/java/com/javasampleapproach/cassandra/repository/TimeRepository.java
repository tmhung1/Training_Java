package com.javasampleapproach.cassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.cassandra.jpamodel.Time;

@Repository
public interface TimeRepository extends CrudRepository<Time, UUID> {

}
