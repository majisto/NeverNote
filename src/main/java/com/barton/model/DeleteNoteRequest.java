package com.barton.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * NeverNote Created by Majisto on 8/31/2018.
 */
@Data
public class DeleteNoteRequest {
    @NotNull
    private int noteBookID;
    @NotNull
    private String title;
}
