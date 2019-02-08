package ru.findplace.demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.findplace.demo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
