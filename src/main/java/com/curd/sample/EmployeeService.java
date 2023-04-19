package com.curd.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        Employee employee1= employeeRepository.findEmployeByName(employee.getName());
        if(employee1 == null) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    public List<Employee> saveAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);

    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeByName(String name){
        Employee employeName = employeeRepository.findEmployeByName(name);
        if (employeName == null){
            return null;
        }
        return employeName;
    }

    public Employee getEmployeById(int id){
        Employee uniqueId = employeeRepository.findById(id).get();
        if (uniqueId == null ){
            return uniqueId;
        }
        return uniqueId;

    }

    public Employee updateEmployeById(int id, Employee employee){
        Employee existingEmploye = employeeRepository.findById(id).get();
        if (existingEmploye != null ){
            existingEmploye.setName(employee.getName());
            existingEmploye.setCity(employee.getCity());
            existingEmploye.setCompany(employee.getCompany());
            existingEmploye.setSalary(employee.getSalary());
            employeeRepository.save(existingEmploye);
            return existingEmploye;
        }
        return existingEmploye;


    }

    public String deleteEmployeById(int id){
        Employee existingEmploye = employeeRepository.findById(id).get();
        if (existingEmploye != null ){
            employeeRepository.deleteById(existingEmploye.getId());
            return " Employe with this "+id+" deleted";
        }
        return "Employe with this id not found";

    }
}
