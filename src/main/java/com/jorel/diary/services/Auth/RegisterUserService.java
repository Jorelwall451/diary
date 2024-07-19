package com.jorel.diary.services.Auth;

import com.jorel.diary.dto.Auth.Register.RegisterUserEntryDTO;
import com.jorel.diary.dto.Auth.Register.RegisterUserOutputDTO;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.User.DuplicateEmailException;
import com.jorel.diary.exceptions.User.DuplicateNameException;
import com.jorel.diary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public RegisterUserOutputDTO execute(RegisterUserEntryDTO entry){
        UserEntity newUser = new UserEntity();

        String encodedPassword = passwordEncoder.encode(entry.password());

        if(repository.existsByName(entry.name())){
            throw new DuplicateNameException(entry.name());
        }

        if(repository.existsByEmail(entry.email())){
            throw new DuplicateEmailException(entry.email());
        }

        newUser.setName(entry.name());
        newUser.setEmail(entry.email());
        newUser.setPassword(encodedPassword);
        newUser.setBirthdate(entry.birthdate());

        repository.save(newUser);

        return new RegisterUserOutputDTO(newUser.getId());
    }
}
