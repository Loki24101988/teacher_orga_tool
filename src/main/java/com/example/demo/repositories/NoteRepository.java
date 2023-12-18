package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, String>{

}
