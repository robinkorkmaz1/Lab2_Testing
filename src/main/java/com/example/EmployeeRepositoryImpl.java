package com.example;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employees;

    public EmployeeRepositoryImpl(List<Employee> employees){
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        for (Employee employee : employees) {
            if (employee.getId().equals(e.getId())) {
                employee = e;
                return employee;
            }
        }
        return null;
    }
}