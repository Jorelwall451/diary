package com.jorel.diary.services.Page;

import com.jorel.diary.dto.Page.FindById.FindPageByIdEntryDTO;
import com.jorel.diary.dto.Page.FindById.FindPageByIdOutputDTO;
import com.jorel.diary.entities.PageEntity;
import com.jorel.diary.exceptions.Page.PageIdNotFoundException;
import com.jorel.diary.repositories.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindPageByIdService {
    @Autowired
    PageRepository repository;

    public FindPageByIdOutputDTO execute(FindPageByIdEntryDTO entry){
        Optional<PageEntity> possiblePage = repository.findByIdAndUserId(entry.id(), entry.userId());

        if(possiblePage.isEmpty()){
            throw new PageIdNotFoundException(entry.id(), entry.userId());
        }

        PageEntity page = possiblePage.get();

        return new FindPageByIdOutputDTO(
                page.getId(),
                page.getTitle(),
                page.getDescription(),
                page.getContent(),
                page.getUpdatedAt(),
                page.getCreatedAt()
        );
    }
}
