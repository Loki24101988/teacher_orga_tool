package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Schoolclass;

@Repository
public interface SchoolclassRepository extends JpaRepository<Schoolclass, String>{

}
