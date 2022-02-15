package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    @Test
    public void methodsOfEmployeeTest(){
        Employee employee = new Employee("001",35000);

        assertEquals("001", employee.getId());
        assertEquals(35000, employee.getSalary());
        assertEquals(false,employee.isPaid());
        assertEquals("Employee [id=001, salary=35000.0]" , employee.toString());

        employee.setId("002");
        employee.setSalary(30000);
        employee.setPaid(true);

        assertEquals("002", employee.getId());
        assertEquals(30000, employee.getSalary());
        assertEquals(true, employee.isPaid());
    }

    @Test
    public void payEmployeesMockTest() {
        BankService bsSpy = spy(mock(BankService.class));
        EmployeeRepository erSpy = spy(mock(EmployeeRepository.class));

        doReturn(new ArrayList<Employee>() {
            {
                add(new Employee("001", 35000));
                add(new Employee("002", 30000));
                add(new Employee("003", 40000));
            }
        }).when(erSpy).findAll();
        doThrow(new RuntimeException()).doNothing().when(bsSpy).pay(anyString(), anyDouble());

        EmployeeManager em = new EmployeeManager(erSpy, bsSpy);

        assertEquals(2, em.payEmployees());
        verify(bsSpy, times(3)).pay(anyString(), anyDouble());
    }

    @Test
    public void payEmployeesTest() {
        BankService bsSpy = spy(mock(BankService.class));
        EmployeeRepository er = new EmployeeRepositoryImpl(new ArrayList<Employee>() {
            {
                add(new Employee("001", 35000));
                add(new Employee("002", 30000));
                add(new Employee("003", 40000));
            }
        });

        doThrow(new RuntimeException()).doNothing().when(bsSpy).pay(anyString(), anyDouble());

        EmployeeManager em = new EmployeeManager(er, bsSpy);

        assertEquals(2, em.payEmployees());
        verify(bsSpy, times(3)).pay(anyString(), anyDouble());
        assertEquals(false, er.findAll().get(0).isPaid());
        assertEquals(true, er.findAll().get(1).isPaid());
        assertEquals(true, er.findAll().get(2).isPaid());
    }
}