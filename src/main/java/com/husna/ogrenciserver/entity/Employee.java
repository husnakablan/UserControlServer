package com.husna.ogrenciserver.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee   {

    //private static final long serialVersionUID = -4545317511377039078L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_SEQ_GENERATOR")
    @SequenceGenerator(name = "EMPLOYEES_SEQ_GENERATOR", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private Date hireDate = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_LESSON", joinColumns = {
            @JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "LESSON_ID",
                    nullable = false, updatable = false) })
    private Set<Lesson> lessons;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
