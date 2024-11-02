package com.employee.em_project;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface Emservice {
    String createemployee(Employee employee);
    List<Employee> reademployees();
    boolean deleteemployee(int id);
    String employeeupdate(int id,Employee employee);
    Employee getemployee(int id);
}
