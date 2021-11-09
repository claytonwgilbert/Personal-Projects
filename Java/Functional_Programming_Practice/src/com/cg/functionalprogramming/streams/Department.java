package com.cg.functionalprogramming.streams;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    public List<Employee> getEmployees(){
        return this.employeeList;
    }
}
