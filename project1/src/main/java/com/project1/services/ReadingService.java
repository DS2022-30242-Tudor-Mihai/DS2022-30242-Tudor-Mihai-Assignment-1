package com.project1.services;

import com.project1.dtos.builders.ReadingBuilder;
import com.project1.dtos.validators.ReadingDTO;
import com.project1.entities.Reading;
import com.project1.repositories.ReadingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReadingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadingService.class);
    private final ReadingRepository readingRepository;

    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public List<ReadingDTO> getReadings() {
        List<Reading> readingList = readingRepository.findAll();
        return readingList.stream().map(ReadingBuilder::toReadingDTO).collect(Collectors.toList());
    }

    public ReadingDTO insert(ReadingDTO readingDTO) {
        Reading reading = ReadingBuilder.toEntity(readingDTO);
        reading = readingRepository.save(reading);
        LOGGER.debug("Reading with id {} was inserted in db", reading.getId());
        return ReadingBuilder.toReadingDTO(reading);
    }

    public void delete(Integer id) {
        Optional<Reading> reading = readingRepository.findById(id);
        if (reading.isPresent()) {
            LOGGER.debug("Reading with id {} is deleted from db", reading.get().getId());
            readingRepository.delete(reading.get());
        }
    }

    public ReadingDTO update(ReadingDTO readingDTO) {
        Reading reading = ReadingBuilder.toEntity(readingDTO);
        readingRepository.save(reading);
        return (readingDTO);
    }
}
