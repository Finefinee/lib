package com.dgsw.lib.dto.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddBookRequest {
    @Id
    private String bookID;
    private String bookName;
    private String author;
}
