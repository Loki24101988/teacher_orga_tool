package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Authority;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority, String>{
	
}
