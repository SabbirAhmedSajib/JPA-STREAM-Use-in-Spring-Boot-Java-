package com.jpa_stream.jpa_stream.repository;

import com.jpa_stream.jpa_stream.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
