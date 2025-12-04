package com.example.java.controller;

import com.example.java.model.Employee;
import com.example.java.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees", service.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", service.getById(id));
        return "edit-employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        service.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.delete(id);
        return "redirect:/";
    }
}
