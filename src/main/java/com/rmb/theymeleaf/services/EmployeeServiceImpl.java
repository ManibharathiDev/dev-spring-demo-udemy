package com.rmb.theymeleaf.services;

import com.rmb.theymeleaf.EmployeeRepository;
import com.rmb.theymeleaf.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {

        Optional<Employee> optionalEmployee  = employeeRepository.findById(id);
        Employee employee =null;
        if(optionalEmployee.isPresent())
        {
            employee = optionalEmployee.get();
        }
        else throw new RuntimeException("Employee not found");

        return employee;
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
