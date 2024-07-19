package com.jorel.diary.services.User;

import com.jorel.diary.dto.User.FindById.FindByUserEntryDTO;
import com.jorel.diary.dto.User.FindById.FindByUserOutputDTO;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.User.UserIdNotFoundException;
import com.jorel.diary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserByIdService {
    @Autowired
    UserRepository repository;

    public FindByUserOutputDTO execute(FindByUserEntryDTO entry){
        Optional<UserEntity> possibleUser = repository.findById(entry.id());

        if(possibleUser.isEmpty()){
            throw new UserIdNotFoundException(entry.id());
        }

        UserEntity user = possibleUser.get();

        return new FindByUserOutputDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthdate(),
                user.getUpdatedAt(),
                user.getCreatedAt()
        );
    }
}
