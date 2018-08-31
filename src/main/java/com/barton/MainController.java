package com.barton;

import com.barton.model.*;
import com.barton.service.AddNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * NeverNote Created by Majisto on 8/26/2018.
 */
@RestController
public class MainController {

    private final AddNoteService addNoteService;

    @Autowired
    public MainController(AddNoteService addNoteService) {
        this.addNoteService = addNoteService;
    }

    @PostMapping(path = "/notes/add")
    public void addNote(@RequestBody @Valid AddNoteRequest request){
        addNoteService.addNote(request);
    }

    @PostMapping(path = "/notebook/create")
    public int createNoteBook(@RequestBody @Valid CreateNotebookRequest notebookRequest){
        return addNoteService.createNoteBook(notebookRequest.getName());
    }

    @GetMapping(path = "notebook/get")
    public NoteBook getNoteBookID(@RequestParam @Valid int id){
        return addNoteService.getNoteBookByID(id);
    }

    @GetMapping(path = "notebook/number")
    public int getNumberOfNotebooks(){
        return addNoteService.getNumberOfNotebooks();
    }

    @DeleteMapping(path = "notes/delete")
    public void deleteNote(@RequestBody @Valid DeleteNoteRequest noteRequest){
        addNoteService.deleteNoteByTitle(noteRequest);
    }

    @GetMapping(path = "notes/tags")
    public List<Note> getNotesByTag(@RequestParam @Valid int id, @RequestParam @Valid String tag){
        return addNoteService.getTags(id, tag);
    }

    @PutMapping(path = "notes/update")
    public void updateNote(@RequestBody @Valid AddNoteRequest noteRequest){
        addNoteService.addNote(noteRequest);
    }
}
