package com.teamplay.choimemo.memo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// 리퀘스트는 값에 대한 유효성을 검증할 책임이 있다.
public record MemoRequest(
        @NotBlank(message = "제목은 필수입니다.")
        String title,

        @Size(max = 1000, message = "내용은 1000자 이내여야 합니다.")
        String content
){
}
