package com.jorel.diary.controllers.User;

import com.jorel.diary.dto.User.Patch.PatchUserEntryDTO;
import com.jorel.diary.services.User.PatchUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Validated
public class PatchUserController {
    @Autowired
    PatchUserService service;

    @PatchMapping("/{id}")
    public ResponseEntity<Void> handle(
            @PathVariable UUID id,
            @Valid @RequestBody PatchUserEntryDTO entry
    ){
        service.execute(id, entry);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
