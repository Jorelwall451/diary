package com.jorel.diary.services.User;

import com.jorel.diary.dto.User.Patch.PatchUserEntryDTO;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.Auth.IncorrectPasswordException;
import com.jorel.diary.exceptions.User.UserIdNotFoundException;
import com.jorel.diary.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatchUserService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void execute(UUID id, PatchUserEntryDTO entry){
        Optional<UserEntity> possibleUser = repository.findById(id);

        if(possibleUser.isEmpty()){
            throw new UserIdNotFoundException(id);
        }

        UserEntity user = possibleUser.get();

        boolean correctPassword = passwordEncoder.matches(entry.actualPassword(), user.getPassword());

        if(!correctPassword){
            throw new IncorrectPasswordException();
        }

        BeanUtils.copyProperties(user, entry);

        repository.save(user);
    }
}
