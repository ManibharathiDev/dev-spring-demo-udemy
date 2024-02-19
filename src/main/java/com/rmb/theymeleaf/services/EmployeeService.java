package com.rmb.theymeleaf.services;

import com.rmb.theymeleaf.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteById(long id);
}
