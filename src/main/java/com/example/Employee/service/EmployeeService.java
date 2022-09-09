package com.example.Employee.service;

import com.example.Employee.dao.EmployeeRepository;
import com.example.Employee.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.create(employee);
    }

    public List<Employee> read() {
        return employeeRepository.read();
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.delete(id);
    }

    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
}
