package com.barton.service;

import com.barton.model.AddNoteRequest;
import com.barton.model.Note;
import com.barton.model.NoteBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * NeverNote Created by Majisto on 8/27/2018.
 */
@Service
public class AddNoteService {

    private List<NoteBook> noteBookList = new ArrayList<>();

    public void addNoteBook(AddNoteRequest noteRequest){
        Note note = new Note();
        note.setNote(noteRequest.getBody());
        NoteBook noteBook = new NoteBook();
        noteBook.notes.add(note);
        noteBookList.add(noteBook);
        System.out.println(noteBookList);
    }
}
