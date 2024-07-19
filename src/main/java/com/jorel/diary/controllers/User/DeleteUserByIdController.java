package com.jorel.diary.controllers.User;

import com.jorel.diary.dto.User.DeleteById.DeleteUserByIdEntryDTO;
import com.jorel.diary.services.User.DeleteUserByIdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class DeleteUserByIdController {
    @Autowired
    DeleteUserByIdService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handle(
            @PathVariable UUID id,
            @Valid @RequestBody DeleteUserByIdEntryDTO body
    ){
        DeleteUserByIdEntryDTO entry = new DeleteUserByIdEntryDTO(
                id,
                body.password()
        );

        service.execute(entry);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
