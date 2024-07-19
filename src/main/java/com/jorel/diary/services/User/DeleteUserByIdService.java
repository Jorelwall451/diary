package com.jorel.diary.services.User;

import com.jorel.diary.dto.User.DeleteById.DeleteUserByIdEntryDTO;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.Auth.IncorrectPasswordException;
import com.jorel.diary.exceptions.Auth.UnauthorizedEmailException;
import com.jorel.diary.exceptions.User.UserIdNotFoundException;
import com.jorel.diary.repositories.UserRepository;
import com.jorel.diary.security.GetAuthenticatedEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserByIdService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void execute(DeleteUserByIdEntryDTO entry){
        Optional<UserEntity> possibleUser = repository.findById(entry.id());

        if(possibleUser.isEmpty()){
            throw new UserIdNotFoundException(entry.id());
        }

        UserEntity user = possibleUser.get();

        if(!GetAuthenticatedEmail.compare(user.getEmail())){
            throw new UnauthorizedEmailException();
        }

        boolean correctPassword = passwordEncoder.matches(entry.password(), user.getPassword());

        if(!correctPassword){
            throw new IncorrectPasswordException();
        }

        repository.deleteById(entry.id());
    }
}
