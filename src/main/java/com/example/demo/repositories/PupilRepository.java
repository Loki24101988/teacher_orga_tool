package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Pupil;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, String>{

}
