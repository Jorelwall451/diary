package com.jorel.diary.dto.Page.GetAll;

import com.jorel.diary.entities.PageEntity;

import java.util.List;

public record GetAllPagesOutputDTO(
        List<PageEntity> pages
){}
