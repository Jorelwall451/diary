package com.jorel.diary.dto.Page.FindById;

import java.util.UUID;

public record FindPageByIdEntryDTO(
        Long id,
        UUID userId
){}
