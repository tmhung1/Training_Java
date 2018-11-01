package com.javasampleapproach.cassandra.secutiry.repository;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.cassandra.jpamodel.UserAccount;

@Repository(value="userRepository")
public interface UserRepository extends CrudRepository<UserAccount, Integer> {
		UserAccount findByEmail(String email);
}
