package com.jorel.diary.dto.Page.GetAll;

import java.util.UUID;

public record GetAllPagesEntryDTO(
        UUID userId,
        int page
){}
