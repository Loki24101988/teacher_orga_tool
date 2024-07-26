package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByUsername(String username);
}
