package com.jorel.diary.dto.User.DeleteById;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record DeleteUserByIdEntryDTO(
        UUID id,
        @NotBlank(message = "The password cannot be blank.")
        @NotNull(message = "The password cannot be null.")
        @Length(min = 12, max = 256, message = "The password must be between 12 and 256 characters.")
        String password
){}
