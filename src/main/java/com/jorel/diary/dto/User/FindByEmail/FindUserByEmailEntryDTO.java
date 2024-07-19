package com.jorel.diary.dto.User.FindByEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record FindUserByEmailEntryDTO(
        @NotNull(message = "The email cannot be null.")
        @Email
        String email
){}
