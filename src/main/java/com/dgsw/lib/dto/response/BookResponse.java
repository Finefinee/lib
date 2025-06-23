package com.dgsw.lib.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BookResponse {
    private String id;
    private String name;
    private String author;
    private boolean isLoaned;
}
