package com.barton.model;

import lombok.Data;

import java.util.List;

/**
 * NeverNote Created by Majisto on 8/26/2018.
 */
@Data
public class Note {
    private String body; //Content of note.
    private String timestamp; //Inserted timestamp.
    private String lastModified;
    private String title; //Unique title to note.
    private String noteBookTitle; //Notebook it belongs to.
    private List<String> tags;
}
