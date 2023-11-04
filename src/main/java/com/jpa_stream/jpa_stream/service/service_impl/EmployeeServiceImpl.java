package com.jpa_stream.jpa_stream.service.service_impl;

import com.jpa_stream.jpa_stream.dto.EmployeeDTO;
import com.jpa_stream.jpa_stream.model.Employee;
import com.jpa_stream.jpa_stream.model.Employee$;
import com.jpa_stream.jpa_stream.repository.EmployeeRepo;
import com.jpa_stream.jpa_stream.service.EmployeeService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final ModelMapper mapper;

    @Autowired
    private JPAStreamer jpaStreamer;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }


    private EmployeeDTO mapToDTO(Employee employee){
        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO minimumPaidEmployee() {
        Employee employee =  jpaStreamer.stream(Employee.class).min(Comparator.comparing(Employee::getSalary)).get();
        return mapToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getEmployeeInfo() {
        List<Employee> positivePayInstructions= employeeRepo.findAll();
        return positivePayInstructions.stream()
                .map(this::mapToDTO)
                .toList();

    }

    @Override
    public Map<String, List<Employee>> getEmployeeGroupByDept() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public List<EmployeeDTO> getEmployeeBySalaryRange(long salary1, long salary2) {
        List<Employee> employee = jpaStreamer.stream(Employee.class)
                .filter(Employee$.salary.between(salary1,salary2))
                .collect(Collectors.toList());
        return employee.stream()
                .map(this::mapToDTO)
                .toList();
    }
}
