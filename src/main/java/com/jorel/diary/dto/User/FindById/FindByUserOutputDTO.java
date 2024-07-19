package com.jorel.diary.dto.User.FindById;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record FindByUserOutputDTO(
        UUID id,
        String name,
        String email,
        LocalDate birthdate,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
){}
