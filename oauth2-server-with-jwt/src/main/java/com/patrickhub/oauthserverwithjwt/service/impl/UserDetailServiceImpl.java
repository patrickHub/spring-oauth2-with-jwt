package com.patrickhub.oauthserverwithjwt.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.patrickhub.oauthserverwithjwt.Repository.UserRepository;
import com.patrickhub.oauthserverwithjwt.domain.Authority;
import com.patrickhub.oauthserverwithjwt.domain.User;
import com.patrickhub.oauthserverwithjwt.domain.UserAuthority;
import com.patrickhub.oauthserverwithjwt.domain.dto.MyGrantedAuthority;
import com.patrickhub.oauthserverwithjwt.domain.dto.MyUserDetails;


@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			MyUserDetails myUserDetails = new MyUserDetails();
			myUserDetails.setUsername(user.getUsername());
			myUserDetails.setPassword(user.getPassword());
			Set<MyGrantedAuthority> authorities = new HashSet<MyGrantedAuthority>();
			for(UserAuthority authority : user.getUserAuthorities()) {
				authorities.add(new MyGrantedAuthority(authority.getAuthority().getAuthorityName()));
			}
			myUserDetails.setGrantedAuthorities(authorities);
			return myUserDetails;
		}
		throw new UsernameNotFoundException(username);
	}
}
