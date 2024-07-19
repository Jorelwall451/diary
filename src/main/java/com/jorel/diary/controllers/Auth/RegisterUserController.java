package com.jorel.diary.controllers.Auth;

import com.jorel.diary.dto.Auth.Register.RegisterUserEntryDTO;
import com.jorel.diary.dto.Auth.Register.RegisterUserOutputDTO;
import com.jorel.diary.services.Auth.RegisterUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterUserController {
    @Autowired
    RegisterUserService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserOutputDTO> handle(
            @Valid @RequestBody RegisterUserEntryDTO entry
    ){
        RegisterUserOutputDTO output = service.execute(entry);

        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
