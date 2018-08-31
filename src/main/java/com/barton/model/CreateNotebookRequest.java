package com.barton.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * NeverNote Created by Majisto on 8/28/2018.
 */
@Data
public class CreateNotebookRequest {
    @NotNull
    public String name;
}
