package com.g1.expertise.service;



import java.util.List;

import com.g1.expertise.model.Employee;

public interface EmployeeService {
	
	Employee findById(int id);
    
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
 
    List<Employee> findAllEmployees(); 
     
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);

}

