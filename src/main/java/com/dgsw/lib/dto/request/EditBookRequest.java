package com.dgsw.lib.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EditBookRequest {
    private String id;
    private String title;
    private String author;
    private boolean loaned;
}
