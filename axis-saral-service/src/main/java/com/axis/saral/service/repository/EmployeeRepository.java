package com.axis.saral.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}