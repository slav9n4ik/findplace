package ru.findplace.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.findplace.demo.entity.Interest;

public interface InterestRrepository extends JpaRepository<Interest, Long> {
}
