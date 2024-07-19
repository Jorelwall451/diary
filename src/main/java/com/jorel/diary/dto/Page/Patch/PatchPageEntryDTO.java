package com.jorel.diary.dto.Page.Patch;

import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record PatchPageEntryDTO(
        Long id,
        UUID userId,
        @Length(min = 2, max = 25, message = "The title must be between 3 and 20 characters.")
        String title,
        @Length(max = 255, message = "The title must be smaller than 255 characters.")
        String description,
        String content
){}
