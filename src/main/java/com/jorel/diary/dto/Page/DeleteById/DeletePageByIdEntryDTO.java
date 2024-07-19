package com.jorel.diary.dto.Page.DeleteById;

import java.util.UUID;

public record DeletePageByIdEntryDTO(
        Long id,
        UUID userId
){}
