package com.employee.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Emserviceimp implements Emservice{

    @Autowired
    private Emrepository emrepository;
 
    @Override
    public String createemployee(Employee employee) {
        Ementity emplEmentity=new Ementity();
        BeanUtils.copyProperties(employee, emplEmentity);
        emrepository.save(emplEmentity);
        // employees.add(employee);
        return "successfully added";
    }

    @Override
    public Employee getemployee(int id) {
        Ementity ementity=emrepository.findById(id).get();
        Employee emp=new Employee();
        BeanUtils.copyProperties(ementity,emp);
        return emp;
    }


    @Override
    public List<Employee> reademployees() {
        List<Employee> employees=new ArrayList<>();
        List<Ementity> ementities=emrepository.findAll();
        for(Ementity ementity:ementities){
            Employee emp=new Employee();
            emp.setId(ementity.getId());
            emp.setPhone(ementity.getPhone());
            emp.setEmail(ementity.getEmail());
            emp.setName(ementity.getName());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteemployee(int id) {
        Ementity ementity=emrepository.findById(id).get();
        emrepository.delete(ementity);
        return true;
    }

    @Override
    public String employeeupdate(int id, Employee employee) {
        Ementity ementity=emrepository.findById(id).get();
        ementity.setEmail(employee.getEmail());
        ementity.setName(employee.getName());
        ementity.setPhone(employee.getPhone());
        emrepository.save(ementity);
        return "succesfully updated";
    }

    

}
