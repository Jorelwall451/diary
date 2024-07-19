package com.jorel.diary.services.Page;

import com.jorel.diary.dto.Page.Patch.PatchPageEntryDTO;
import com.jorel.diary.entities.PageEntity;
import com.jorel.diary.exceptions.Page.PageIdNotFoundException;
import com.jorel.diary.repositories.PageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatchPageService {
    @Autowired
    PageRepository repository;

    public void execute(PatchPageEntryDTO entry){
        Optional<PageEntity> possiblePage = repository.findByIdAndUserId(entry.id(), entry.userId());

        if(possiblePage.isEmpty()){
            throw new PageIdNotFoundException(entry.id(), entry.userId());
        }

        PageEntity page = possiblePage.get();

        BeanUtils.copyProperties(page, entry);

        repository.save(page);
    }
}
