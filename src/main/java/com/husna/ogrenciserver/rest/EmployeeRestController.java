package com.husna.ogrenciserver.rest;

import com.husna.ogrenciserver.entity.Employee;
import com.husna.ogrenciserver.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> GetAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployeesById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }


    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
    }

    @PostMapping(value = "/sorgula")
    public ResponseEntity<List<Employee>> OgrenciSorgula(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.SearchEmployees(employee));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") long id, @RequestBody Employee employee) {
        Employee oldEmployee = employeeService.getEmployeesById(id);
        if (oldEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());

        employeeService.updateEmployee(oldEmployee);
        return ResponseEntity.ok(oldEmployee);
    }

    @PutMapping(value = "/2/{id}")
    public ResponseEntity<Employee> updateAll(@PathVariable("id") long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employeeService.getEmployeesById(employee.getEmployeeId()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(id);
    }


}
