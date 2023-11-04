package com.jpa_stream.jpa_stream.service;

import com.jpa_stream.jpa_stream.dto.EmployeeDTO;
import com.jpa_stream.jpa_stream.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    EmployeeDTO minimumPaidEmployee();

    List<EmployeeDTO> getEmployeeInfo();

    Map<String, List<Employee>> getEmployeeGroupByDept();

    List<EmployeeDTO> getEmployeeBySalaryRange(long salary1, long salary2);
}
