package com.project1.controllers;

import com.project1.dtos.validators.ReadingDTO;
import com.project1.services.ReadingService;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("reading")
public class ReadingController {
    private final ReadingService readingService;

    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ReadingDTO>> getReadings() {
        List<ReadingDTO> readingDTOS = readingService.getReadings();
        for (ReadingDTO dto : readingDTOS) {
            Link readingLink = linkTo(methodOn(DeviceController.class)
                    .getDevices()).withRel("deviceDetails");
            dto.add(readingLink);
        }
        return new ResponseEntity<>(readingDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ReadingDTO> insertReading(@Valid @RequestBody ReadingDTO readingDTO) {
        ReadingDTO readingDTO1 = readingService.insert(readingDTO);
        return new ResponseEntity<>(readingDTO1, HttpStatus.CREATED);
    }
}
