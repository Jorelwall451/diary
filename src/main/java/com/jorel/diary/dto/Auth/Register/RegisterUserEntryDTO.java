package com.jorel.diary.dto.Auth.Register;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RegisterUserEntryDTO(
        @NotBlank(message = "The name cannot be blank.")
        @NotNull(message = "The name cannot be null.")
        @Length(min = 3, max = 20, message = "The name must be between 3 and 20 characters")
        String name,
        @NotNull(message = "The email cannot be null.")
        @Email
        String email,
        @NotBlank(message = "The password cannot be blank.")
        @NotNull(message = "The password cannot be null.")
        @Length(min = 12, max = 256, message = "The password must be between 12 and 256 characters.")
        String password,
        @NotNull(message = "The birthdate cannot be null.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate birthdate
){}
