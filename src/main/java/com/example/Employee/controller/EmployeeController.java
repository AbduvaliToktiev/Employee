package com.example.Employee.controller;

import com.example.Employee.entities.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/create-employee")
    public String create(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return "CREATE!";
    }

  @GetMapping(value = "/read-employee")
  public List<Employee> read() {
      return employeeService.read();
  }

  @PutMapping(value = "/update-employee")
    public String update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return "UPDATE!";
  }

  @DeleteMapping(value = "/delete-employee")
    public String delete(@RequestParam(name = "id") Integer id) {
        employeeService.deleteEmployee(id);
        return "DELETE!";
  }

  @DeleteMapping(value = "/delete-all-employee")
    public String deleteAll() {
        employeeService.deleteAllEmployee();
        return "DELETE ALL!";
  }
}
