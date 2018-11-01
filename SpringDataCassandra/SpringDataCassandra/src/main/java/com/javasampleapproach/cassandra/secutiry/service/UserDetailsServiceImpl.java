package com.javasampleapproach.cassandra.secutiry.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javasampleapproach.cassandra.jpamodel.RoleAccount;
import com.javasampleapproach.cassandra.jpamodel.UserAccount;
import com.javasampleapproach.cassandra.secutiry.repository.RoleRepository;
import com.javasampleapproach.cassandra.secutiry.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	@Transactional	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount user=userRepository.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Not found user in Database");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<RoleAccount>roles=user.getRoles();
		for(RoleAccount r:roles)
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(r.getName()));
		}
		//implementation UserDetail
		return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), grantedAuthorities);
	}

}
