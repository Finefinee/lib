package com.dgsw.lib.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EditBookRequest {
    @NotBlank(message = "도서 ID는 필수입니다")
    private String id;

    @NotBlank(message = "도서 제목은 필수입니다")
    private String title;

    @NotBlank(message = "저자명은 필수입니다")
    private String author;

    @NotNull(message = "대출 상태는 필수입니다")
    private boolean loaned;
}
