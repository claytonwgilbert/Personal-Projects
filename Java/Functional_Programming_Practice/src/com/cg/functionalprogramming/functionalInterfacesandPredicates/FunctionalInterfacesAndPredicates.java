package com.cg.functionalprogramming.functionalInterfacesandPredicates;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfacesAndPredicates {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Ruby Jane", 18);
        Employee emp2 = new Employee("John Jones", 34);
        Employee emp3 = new Employee("Snow White", 22);
        Employee emp4 = new Employee("Loretta Jaimes", 50);
        Employee emp5 = new Employee("Liquor Rhymes", 45);
        Employee emp6 = new Employee("Reed Weller", 27);
        Employee emp7 = new Employee("Jonesses Black", 30);
        Employee emp8 = new Employee("Liberty Osmosis", 38);
        Employee emp9 = new Employee("Stryker Wayne", 60);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
        employees.add(emp7);
        employees.add(emp8);
        employees.add(emp9);

        // - Seeing the predicate method created below in action, one tests for employees over 30 and the other for
        // employees 30 and younger
        printEmployeesByAge(employees, "===== Employees over 30 ======", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "===== Employees 30 and younger ======", employee -> employee.getAge() <= 30);

        // - Predicates for testing integer values against a condition
        IntPredicate greaterThanFifteen = i -> i > 15;
        IntPredicate lessThanAHundred = i -> i < 100;
        System.out.println(greaterThanFifteen.test(14));

        // - Chaining multiple predicates together
        System.out.println(greaterThanFifteen.and(lessThanAHundred).test(50));

        // - Example of Supplier - takes in no arguments and always returns a value
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(500);
        for(int i = 0; i < 10; i++){
            System.out.println(randomSupplier.get());
        }

        // - Function interface, takes in one argument and returns a value. Here we use one to get the last name of an employee
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);

        // - Function for getting first name
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        // - Example of randomly using either the firstName function or the lastName function with the getAName method created below
        Random random1 = new Random();
        for(Employee employee : employees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            }else{
                System.out.println(getAName(getLastName, employee));
            }
        }

        // - Chaining functions together, upper casing the whole name, then just grabbing the first part of the name
        Function<Employee, String> upperCaseFunction = (Employee e) -> e.getName().toUpperCase();
        // - Function below works on what has been returned from the function above...
        Function<String, String> getFirstNameFunction = name -> name.substring(0, name.indexOf(' '));
        // - Above functions chained...
        Function chainedFunction = upperCaseFunction.andThen(getFirstNameFunction);
        System.out.println(chainedFunction.apply(employees.get(0)));

        // - Function that takes in multiple arguments and returns value, here we simply concat name and age
        BiFunction<String, Employee, String> concatEmployeeAges = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };
        // - Use the upperCaseFunction to upper case the first name, then call BiFunction and pass in results from upper case as
        // - well as employee to process...
        String upperName = upperCaseFunction.apply(employees.get(0));

        System.out.println(concatEmployeeAges.apply(upperName, employees.get(0)));
    }

    // - Showing the benefits of function interface, mainly being able to pass a function interface into a method as a lambda
    //for ultimate flexibility
    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    // - Using a predicate to test multiple conditions using an employees age...Predicates return true or false
    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("==================");
        for(Employee employee : employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}

