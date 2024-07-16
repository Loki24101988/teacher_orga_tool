package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	private NoteRepository noteRepository;
	
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
}
