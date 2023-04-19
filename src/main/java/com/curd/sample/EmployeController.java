package com.curd.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee saveEmploye(@RequestBody Employee employee){
       return employeeService.saveEmployee(employee);

    }

    @GetMapping("/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name){
        return employeeService.getEmployeByName(name);

    }
    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployeById(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployeById(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeById(@PathVariable int id){
        return employeeService.deleteEmployeById(id);
    }
}
