package ru.findplace.demo.dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.findplace.demo.entity.Employee;
import ru.findplace.demo.repository.EmployeeRepository;

@Component
public class DataPreLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    @Autowired
    public DataPreLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
    }
}
