package com.jorel.diary.controllers.Auth;

import com.jorel.diary.dto.Auth.Login.LoginUserEntryDTO;
import com.jorel.diary.dto.Auth.Login.LoginUserOutputDTO;
import com.jorel.diary.services.Auth.LoginUserService;
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
public class LoginUserController {
    @Autowired
    LoginUserService service;

    @PostMapping("/login")
    public ResponseEntity<LoginUserOutputDTO> handle(
            @Valid @RequestBody LoginUserEntryDTO entry
    ){
        LoginUserOutputDTO output = service.execute(entry);

        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
