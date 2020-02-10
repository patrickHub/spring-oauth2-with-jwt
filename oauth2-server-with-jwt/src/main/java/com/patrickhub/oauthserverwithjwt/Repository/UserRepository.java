package com.patrickhub.oauthserverwithjwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patrickhub.oauthserverwithjwt.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT DISTINCT u FROM users u WHERE u.username = :username")
	User findByUsername(@Param("username") String username);
}
