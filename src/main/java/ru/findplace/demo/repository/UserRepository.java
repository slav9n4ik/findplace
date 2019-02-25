package ru.findplace.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.findplace.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findFirstByEmail(String email);
    User findByName(String email);
}
