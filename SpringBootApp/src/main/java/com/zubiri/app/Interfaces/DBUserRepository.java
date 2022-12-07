package com.zubiri.app.Interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zubiri.app.beans.User;



public interface DBUserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
