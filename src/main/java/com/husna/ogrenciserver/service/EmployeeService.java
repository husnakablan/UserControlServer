package com.husna.ogrenciserver.service;

import com.husna.ogrenciserver.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> getAllEmployee();

     Employee getEmployeesById(long id);

     long addEmployee(Employee employee);

     void deleteEmployee(long employeeId);

     long updateEmployee(Employee employee);

     Employee save(Employee employee);

     List<Employee> SearchEmployees(Employee employee);

     List<Employee> filter(Employee employee);
}
