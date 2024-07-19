package com.jorel.diary.dto.User.FindByEmail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record FindUserByEmailOutputDTO(
        UUID id,
        String name,
        String email,
        LocalDate birthdate,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
){}
