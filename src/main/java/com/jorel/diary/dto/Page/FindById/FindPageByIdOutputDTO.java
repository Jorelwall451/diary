package com.jorel.diary.dto.Page.FindById;

import java.time.LocalDateTime;

public record FindPageByIdOutputDTO(
        Long id,
        String title,
        String description,
        String content,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
){}
