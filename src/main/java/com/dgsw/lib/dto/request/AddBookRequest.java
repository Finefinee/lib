package com.dgsw.lib.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddBookRequest {
    private String bookID;
    private String bookName;
    private String author;
}
