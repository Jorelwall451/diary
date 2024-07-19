package com.jorel.diary.controllers.User;

import com.jorel.diary.dto.User.FindByEmail.FindUserByEmailEntryDTO;
import com.jorel.diary.dto.User.FindByEmail.FindUserByEmailOutputDTO;
import com.jorel.diary.services.User.FindUserByEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class FindUserByEmailController {
    @Autowired
    FindUserByEmailService service;

    @GetMapping("/")
    public ResponseEntity<FindUserByEmailOutputDTO> handle(
            @RequestBody FindUserByEmailEntryDTO entry
    ){
        FindUserByEmailOutputDTO output = service.execute(entry);

        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
