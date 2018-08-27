package com.barton.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * NeverNote Created by Majisto on 8/26/2018.
 */
@Data
public class NoteBook {
    public List<Note> notes;

    public NoteBook(){
        notes = new ArrayList<>();
    }
}
