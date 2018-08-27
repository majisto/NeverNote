package com.barton.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * NeverNote Created by Majisto on 8/27/2018.
 */
@Data
public class AddNoteRequest {
    @NotNull
    private String title;
    @NotNull
    private String body;
    @NotNull
    private List<String> tags;
}
