package com.barton.service;

import com.barton.model.*;
import com.barton.utils.mainUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * NeverNote Created by Majisto on 8/27/2018.
 */
@Service
public class AddNoteService {

    private List<NoteBook> noteBookList = new ArrayList<>();

    public int createNoteBook(String name){
        NoteBook noteBook = new NoteBook(name);
        noteBookList.add(noteBook);
        return noteBookList.size() - 1; //Want to return index, not size.
    }

    public void addNote(AddNoteRequest noteRequest){
        NoteBook noteBook = noteBookList.get(noteRequest.getNotebookID());
        Note note = new Note();
        note.setBody(noteRequest.getBody());
        note.setTitle(noteRequest.getTitle());
        note.setTimestamp(mainUtils.generateTimeStamp());
        note.setNoteBookTitle(noteBook.getName());
        note.setTags(noteRequest.getTags());
        noteBook.addNote(note);
    }

    public List<Note> getTags(int id, String tag){
        NoteBook noteBook = noteBookList.get(id);
        return noteBook.getNotesForTag(tag);
    }

    public NoteBook getNoteBookByID(int id){
        return noteBookList.get(id);
    }

    public int getNumberOfNotebooks(){
        return noteBookList.size();
    }

    public void deleteNoteByTitle(DeleteNoteRequest noteRequest){
        NoteBook noteBook = noteBookList.get(noteRequest.getNoteBookID());
        noteBook.deleteNoteByTitle(noteRequest.getTitle());
    }

}
