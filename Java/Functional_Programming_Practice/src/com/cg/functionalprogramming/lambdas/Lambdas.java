package com.cg.functionalprogramming.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Printing from the runnable using a lambda");
            System.out.println("Printing line 2...");
            System.out.format("Line...%d\n", 3);
        }).start();

        Employee emp1 = new Employee("Ruby Jane", 18);
        Employee emp2 = new Employee("John Jones", 34);
        Employee emp3 = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        // - Sorting Lambda
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        for(Employee emp : employees){
            System.out.println(emp.getName() + " " + emp.getAge());
        }
        // - Shorthand Sorting Lambda
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        for(Employee emp : employees){
            System.out.println(emp.getName() + " " + emp.getAge());
        }

        // - Lambda with custom interface definition to return arguments back as all caps, defined at bottom of this page
        // - Is used in conjunction with custom method createSillyString below...
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        // - Calling custom method definitions defined below that takes our custom interface and two strings to create a returned
        //result.
        String sillyStringResult = createSillyString(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyStringResult);

        // - Older style for each loop
        for(Employee emp : employees){
            System.out.println(emp.getName());
            System.out.println(emp.getAge());
        }

        // - More streamlines for loop
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });


    }
    public final static String createSillyString(UpperConcat uc, String e1, String e2){
        return uc.upperAndConcat(e1, e2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething(){
        UpperConcat uc = (e1, e2) -> {
            String result = e1.toUpperCase() + e2.toUpperCase();
            return result;
        };

        return Lambdas.createSillyString(uc, "String 1", "String 2");
    }
}
