package com.github.evgdim.jwtsec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.evgdim.jwtsec.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsernameAndPassword(String username, String password);
}
