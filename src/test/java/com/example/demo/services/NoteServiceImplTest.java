package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojos.FormPupil;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;

@SpringBootTest
class NoteServiceImplTest {

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private PupilService pupilService;
	
	@Test
	void testNotesAreOrderedByCreationTimeStamp() {
		FormPupil formPupil = new FormPupil();
		formPupil.setFirstName("Michael");
		formPupil.setLastName("Müller");
		Pupil createdPupil = this.pupilService.createNewPupilFromFormPupil(formPupil);
		Note note1 = new Note("Test123", createdPupil, new Teacher());
		for(int i = 0; i <= Integer.MAX_VALUE; i++) {}
		Note note2 = new Note("Test456", createdPupil, new Teacher());
		for(int i = 0; i <= Integer.MAX_VALUE; i++) {}
		Note note3 = new Note("Test789", createdPupil, new Teacher());
		for(int i = 0; i <= Integer.MAX_VALUE; i++) {}
		Note note4 = new Note("Test123", createdPupil, new Teacher());
		for(int i = 0; i <= Integer.MAX_VALUE; i++) {}
		Note note5 = new Note("Test456", createdPupil, new Teacher());
		
		createdPupil.getNotes().add(note1);
		createdPupil.getNotes().add(note2);
		createdPupil.getNotes().add(note3);
		createdPupil.getNotes().add(note4);
		createdPupil.getNotes().add(note5);
		this.pupilService.storePupil(createdPupil);
		List<Note> allNotesForPupil = this.noteService.getAllNotesForPupil(createdPupil);
		
		assertNotNull(allNotesForPupil);
		assertEquals(allNotesForPupil.size(), 5);
		
		for(Note note: allNotesForPupil) {
			System.out.println("content: " + note.getContent() + "; Created At: " + note.getCreatedAt());
		}
		
		assertTrue(allNotesForPupil.get(0).getCreatedAt().isAfter(allNotesForPupil.get(1).getCreatedAt()));
		
		Pupil deleteAllNotesForPupil = this.pupilService.deleteAllNotesForPupil(createdPupil);
		assertEquals(deleteAllNotesForPupil.getNotes().size(), 0);
		
	}

}
