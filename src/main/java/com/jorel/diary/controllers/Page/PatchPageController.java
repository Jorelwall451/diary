package com.jorel.diary.controllers.Page;

import com.jorel.diary.dto.Page.Patch.PatchPageEntryDTO;
import com.jorel.diary.services.Page.PatchPageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}")
public class PatchPageController {
    @Autowired
    PatchPageService service;

    @PatchMapping("/{id}")
    public ResponseEntity<Void> execute(
            @PathVariable("userId") UUID userId,
            @PathVariable Long id,
            @Valid @RequestBody PatchPageEntryDTO body
    ){
        PatchPageEntryDTO entry = new PatchPageEntryDTO(
                id,
                userId,
                body.title(),
                body.description(),
                body.content()
        );

        service.execute(entry);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
