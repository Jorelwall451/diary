package com.jorel.diary.services.Auth;

import com.jorel.diary.dto.Auth.Login.LoginUserEntryDTO;
import com.jorel.diary.dto.Auth.Login.LoginUserOutputDTO;
import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.Auth.EmailOrPasswordIncorrectException;
import com.jorel.diary.exceptions.User.UserEmailNotFoundException;
import com.jorel.diary.repositories.UserRepository;
import com.jorel.diary.services.Auth.Token.GenerateTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserService {
    @Autowired
    UserRepository repository;
    @Autowired
    GenerateTokenService generateTokenService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public LoginUserOutputDTO execute(LoginUserEntryDTO entry){
        Optional<UserEntity> possibleUser = repository.findByEmail(entry.email());

        if(possibleUser.isEmpty()){
            throw new UserEmailNotFoundException(entry.email());
        }

        UserEntity user = possibleUser.get();

        boolean correctPassword = passwordEncoder.matches(entry.password(), user.getPassword());

        if(!correctPassword){
            throw new EmailOrPasswordIncorrectException();
        }

        String token = generateTokenService.execute(user.getEmail());

        return new LoginUserOutputDTO(token);
    }
}
