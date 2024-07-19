package com.jorel.diary.services.Page;

import com.jorel.diary.dto.Page.Create.CreatePageEntryDTO;
import com.jorel.diary.dto.Page.Create.CreatePageOutputDTO;
import com.jorel.diary.entities.PageEntity;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.User.UserIdNotFoundException;
import com.jorel.diary.repositories.PageRepository;
import com.jorel.diary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePageService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PageRepository repository;

    public CreatePageOutputDTO execute(CreatePageEntryDTO entry){
        Optional<UserEntity> possibleUser = userRepository.findById(entry.userId());

        if(possibleUser.isEmpty()){
            throw new UserIdNotFoundException(entry.userId());
        }

        UserEntity user = possibleUser.get();

        PageEntity newPage = new PageEntity();

        newPage.setTitle(entry.title());
        newPage.setDescription(entry.description());
        newPage.setContent(entry.content());
        newPage.setUser(user);

        repository.save(newPage);

        return new CreatePageOutputDTO(newPage.getId());
    }
}
