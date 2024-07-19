package com.jorel.diary.controllers.User;

import com.jorel.diary.dto.User.FindById.FindByUserEntryDTO;
import com.jorel.diary.dto.User.FindById.FindByUserOutputDTO;
import com.jorel.diary.services.User.FindUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class FindUserByIdController {
    @Autowired
    FindUserByIdService service;

    @GetMapping("/{id}")
    public ResponseEntity<FindByUserOutputDTO> handle(
            @PathVariable UUID id
    ){
        FindByUserEntryDTO entry = new FindByUserEntryDTO(id);

        FindByUserOutputDTO user = service.execute(entry);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
