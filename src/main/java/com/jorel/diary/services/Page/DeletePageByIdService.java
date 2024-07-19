package com.jorel.diary.services.Page;

import com.jorel.diary.dto.Page.DeleteById.DeletePageByIdEntryDTO;
import com.jorel.diary.entities.PageEntity;
import com.jorel.diary.exceptions.Page.PageIdNotFoundException;
import com.jorel.diary.repositories.PageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePageByIdService {
    @Autowired
    PageRepository repository;

    @Transactional
    public void execute(DeletePageByIdEntryDTO entry){
        Optional<PageEntity> possiblePage = repository.findByIdAndUserId(entry.id(), entry.userId());

        if(possiblePage.isEmpty()){
            throw new PageIdNotFoundException(entry.id(), entry.userId());
        }

        repository.deleteByIdAndUserId(entry.id(), entry.userId());
    }
}
