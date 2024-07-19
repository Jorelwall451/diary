package com.jorel.diary.dto.Page.Create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record CreatePageEntryDTO(
        UUID userId,
        @NotBlank(message = "The title cannot be blank.")
        @NotNull(message = "The title cannot be null.")
        @Length(min = 2, max = 25, message = "The title must be between 3 and 20 characters.")
        String title,
        @NotBlank(message = "The description cannot be blank.")
        @Length(max = 255, message = "The title must be smaller than 255 characters.")
        String description,
        @NotBlank(message = "The content cannot be blank.")
        @NotNull(message = "The content cannot be null.")
        String content
){}
