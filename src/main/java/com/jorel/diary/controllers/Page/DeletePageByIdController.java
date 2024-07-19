package com.jorel.diary.controllers.Page;

import com.jorel.diary.dto.Page.DeleteById.DeletePageByIdEntryDTO;
import com.jorel.diary.services.Page.DeletePageByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}")
public class DeletePageByIdController {
    @Autowired
    DeletePageByIdService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handle(
            @PathVariable Long id,
            @PathVariable("userId") UUID userId
    ){
        DeletePageByIdEntryDTO entry = new DeletePageByIdEntryDTO(id, userId);

        service.execute(entry);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
