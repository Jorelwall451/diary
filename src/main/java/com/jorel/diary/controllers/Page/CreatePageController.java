package com.jorel.diary.controllers.Page;

import com.jorel.diary.dto.Page.Create.CreatePageEntryDTO;
import com.jorel.diary.dto.Page.Create.CreatePageOutputDTO;
import com.jorel.diary.services.Page.CreatePageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}")
public class CreatePageController {
    @Autowired
    CreatePageService service;

    @PostMapping("/")
    public ResponseEntity<CreatePageOutputDTO> execute(
            @PathVariable("userId") UUID userId,
            @Valid @RequestBody CreatePageEntryDTO body
    ){
        CreatePageEntryDTO entry = new CreatePageEntryDTO(
                userId,
                body.title(),
                body.description(),
                body.content()
        );

        CreatePageOutputDTO output = service.execute(entry);

        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
