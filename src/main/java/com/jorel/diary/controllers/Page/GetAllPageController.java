package com.jorel.diary.controllers.Page;

import com.jorel.diary.dto.Page.GetAll.GetAllPagesEntryDTO;
import com.jorel.diary.dto.Page.GetAll.GetAllPagesOutputDTO;
import com.jorel.diary.services.Page.GetAllPagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}")
public class GetAllPageController {
    @Autowired
    GetAllPagesServices service;

    @GetMapping("/")
    public ResponseEntity<GetAllPagesOutputDTO> execute(
            @PathVariable("userId") UUID userId,
            @RequestParam Integer page
    ){
        GetAllPagesEntryDTO entry = new GetAllPagesEntryDTO(userId, page);

        GetAllPagesOutputDTO output = service.execute(entry);

        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
