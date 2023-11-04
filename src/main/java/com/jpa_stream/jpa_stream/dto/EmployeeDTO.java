package com.jpa_stream.jpa_stream.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private long uniqueId;
    private long employeeId;
    private String employeeName;
    private String department;
    private long salary;
}
