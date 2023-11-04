package com.jpa_stream.jpa_stream.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_id")
    @SequenceGenerator(sequenceName = "sq_employee", allocationSize = 1, name = "unique_id")
    private long uniqueId;
    private long employeeId;
    private String employeeName;
    private String department;
    private long salary;
}
