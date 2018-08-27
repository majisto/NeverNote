package com.barton;

import com.barton.model.AddNoteRequest;
import com.barton.service.AddNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(path = "/notes")
    public void addNote(@RequestBody @Valid AddNoteRequest request){
        System.out.println(request);
        addNoteService.addNoteBook(request);
    }
}
