package com.jorel.diary.services.User;

import com.jorel.diary.dto.User.FindByEmail.FindUserByEmailEntryDTO;
import com.jorel.diary.dto.User.FindByEmail.FindUserByEmailOutputDTO;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.User.UserEmailNotFoundException;
import com.jorel.diary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserByEmailService {
    @Autowired
    UserRepository repository;

    public FindUserByEmailOutputDTO execute(FindUserByEmailEntryDTO entry){
        Optional<UserEntity> possibleUser = repository.findByEmail(entry.email());

        if(possibleUser.isEmpty()){
            throw new UserEmailNotFoundException(entry.email());
        }

        UserEntity user = possibleUser.get();

        return new FindUserByEmailOutputDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthdate(),
                user.getUpdatedAt(),
                user.getCreatedAt()
        );
    }
}
