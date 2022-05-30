package com.baykin.auth_service.repository;

import org.springframework.data.repository.CrudRepository;
import com.baykin.auth_service.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
