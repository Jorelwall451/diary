package com.jorel.diary.dto.Auth.Login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LoginUserEntryDTO(
        @NotNull(message = "The email cannot be null.")
        @Email
        String email,
        @NotBlank(message = "The password cannot be blank.")
        @NotNull(message = "The password cannot be null.")
        @Length(min = 12, max = 256, message = "The password must be between 12 and 256 characters")
        String password
){}
