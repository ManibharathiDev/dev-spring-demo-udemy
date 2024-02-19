package com.rmb.theymeleaf.controller;

import com.rmb.theymeleaf.EmployeeRepository;
import com.rmb.theymeleaf.entities.Employee;
import com.rmb.theymeleaf.services.EmployeeService;
import com.rmb.theymeleaf.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        model.addAttribute("allemplist",employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model)
    {
        Employee employees = new Employee();
        model.addAttribute("employee",employees);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("showFormForUpdate/{id}")
    public String updateForm(@PathVariable (value = "id") long id, Model model)
    {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee",employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id)
    {
        employeeService.deleteById(id);
        return "redirect:/";
    }

}
