package com.example.java.service;

import com.example.java.model.Employee;
import com.example.java.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
