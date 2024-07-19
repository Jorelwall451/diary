package com.jorel.diary.dto.User.Patch;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record PatchUserEntryDTO(
        @NotNull(message = "The password cannot be null.")
        @NotBlank(message = "The password cannot be blank.")
        String actualPassword,

        @Length(min = 3, max = 20, message = "The name must be between 3 and 20 characters.")
        String name,
        @Email
        String email,
        @Length(min = 12, max = 256, message = "The password must be between 12 and 256 characters.")
        String password,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate birthdate
){}
