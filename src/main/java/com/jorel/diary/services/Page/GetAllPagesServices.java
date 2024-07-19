package com.jorel.diary.services.Page;

import com.jorel.diary.dto.Page.GetAll.GetAllPagesEntryDTO;
import com.jorel.diary.dto.Page.GetAll.GetAllPagesOutputDTO;
import com.jorel.diary.repositories.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GetAllPagesServices {
    @Autowired
    PageRepository repository;

    public GetAllPagesOutputDTO execute(GetAllPagesEntryDTO entry){
        PageRequest pageRequest = PageRequest.of(entry.page(), 10);

        return new GetAllPagesOutputDTO(
                repository.findAllByUserId(entry.userId(), pageRequest)
        );
    }
}
