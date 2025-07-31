package com.dgsw.lib.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ReturnRequest {
    @NotBlank(message = "도서 ID는 필수입니다")
    private String bookId;
}
