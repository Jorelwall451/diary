package com.jorel.diary.controllers.Page;

import com.jorel.diary.dto.Page.FindById.FindPageByIdEntryDTO;
import com.jorel.diary.dto.Page.FindById.FindPageByIdOutputDTO;
import com.jorel.diary.services.Page.FindPageByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}")
public class FindPageByIdController {
    @Autowired
    FindPageByIdService service;

    @GetMapping("/{id}")
    public ResponseEntity<FindPageByIdOutputDTO> execute(
            @PathVariable("userId") UUID userId,
            @PathVariable Long id
    ){
        FindPageByIdEntryDTO entry = new FindPageByIdEntryDTO(id, userId);

        FindPageByIdOutputDTO output = service.execute(entry);

        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
