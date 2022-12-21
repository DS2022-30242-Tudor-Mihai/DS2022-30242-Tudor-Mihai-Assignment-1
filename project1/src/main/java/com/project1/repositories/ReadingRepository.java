package com.project1.repositories;

import com.project1.entities.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Integer> {
}
