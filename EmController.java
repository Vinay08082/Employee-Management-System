package com.employee.em_project;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;




@RestController
@CrossOrigin("http://localhost:5173/")
public class EmController {
    // @Autowired
    // Emservice emp=new Emserviceimp();
    // dependency injection =>
    @Autowired
    Emservice emp; 
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return emp.reademployees();
    }
    @GetMapping("employees/{id}")
    public Employee getMethodName(@PathVariable int id) {
        return emp.getemployee(id);
    }
    
    @PostMapping("employees")
    public String postMethodName(@RequestBody Employee employee) {
        // employees.add(employee);
        return emp.createemployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String delelteemployee(@PathVariable int id){
        if(emp.deleteemployee(id)){
            return "successfully deleted";
        }
        return "Not found";
    }
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Employee employee) {
        
        return emp.employeeupdate(id,employee);
    }
}
