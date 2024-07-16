package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, String>{
	List<Note> findByReceiver(Pupil receiver);
	List<Note> findByCreator(Teacher creator);
}
