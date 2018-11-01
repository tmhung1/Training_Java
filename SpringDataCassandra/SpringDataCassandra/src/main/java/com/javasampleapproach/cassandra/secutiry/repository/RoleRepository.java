package com.javasampleapproach.cassandra.secutiry.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.cassandra.jpamodel.RoleAccount;


@Repository(value="roleRepository")
public interface RoleRepository extends CrudRepository<RoleAccount, Integer> {
		RoleAccount findByName(String name);
}
