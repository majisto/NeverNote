package com.barton.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * NeverNote Created by Majisto on 8/28/2018.
 */
@Data
public class GetTagsRequest {
    @NotNull
    private int noteBookID;
    @NotNull
    private String tag;
}
