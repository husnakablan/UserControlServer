package com.husna.ogrenciserver.service;

import com.husna.ogrenciserver.entity.Employee;
import com.husna.ogrenciserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll() ;
    }

    @Override
    public Employee getEmployeesById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public long addEmployee(Employee employee) {
        return employeeRepository.save(employee).getEmployeeId();
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public long updateEmployee(Employee employee) {
        return employeeRepository.save(employee).getEmployeeId();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> SearchEmployees(Employee employee) {

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Employee> examples = Example.of(employee, customExampleMatcher);

        return employeeRepository.findAll(examples);
    }

    @Override
    public List<Employee> filter(Employee employee) {
        return employeeRepository.filter(employee.getFirstName(),employee.getLastName(),employee.getEmail());
    }

}
