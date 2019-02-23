package ru.findplace.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.findplace.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
}
