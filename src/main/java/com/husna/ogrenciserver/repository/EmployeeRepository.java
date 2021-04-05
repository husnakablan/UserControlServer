package com.husna.ogrenciserver.repository;

import com.husna.ogrenciserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e FROM Employee e  where lower(e.firstName) like lower(concat('%', :firstName,'%')) " +
            " and lower(e.lastName) like lower(concat('%', :lastName,'%')) and  lower(e.email) like lower(concat('%', :email,'%'))")
     List<Employee> filter( @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email);
}
