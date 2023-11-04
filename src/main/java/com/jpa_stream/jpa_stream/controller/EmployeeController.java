package com.jpa_stream.jpa_stream.controller;

import com.jpa_stream.jpa_stream.dto.EmployeeDTO;
import com.jpa_stream.jpa_stream.model.Employee;
import com.jpa_stream.jpa_stream.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployeeInfo(){
        return employeeService.getEmployeeInfo();
    }

    @GetMapping("/minimum-salary")
    public EmployeeDTO minimumPaidSalaryInfo(){
        return employeeService.minimumPaidEmployee();
    }


    @GetMapping("/department")
    public Map<String, List<Employee>> getEmployeeGroupByDept(){
        return employeeService.getEmployeeGroupByDept();
    }

    @GetMapping("/salary-between/{salary1},{salary2}")
    List<EmployeeDTO> getEmployeeBySalaryRange(@PathVariable long salary1, @PathVariable long salary2){
        return employeeService.getEmployeeBySalaryRange(salary1,salary2);
    }
}
