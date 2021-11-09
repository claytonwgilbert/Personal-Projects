package com.cg.functionalprogramming.streams;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40","N36",
                "B12","B55",
                "G6","G49","G53","G60","g99",
                "I26","I17","I29",
                "O71");

        // - Traditional Way to print out all numbers starting with G
        List<String> gNumbers = new ArrayList<>();

        bingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
            }
        });
        gNumbers.sort(Comparator.naturalOrder());
        gNumbers.forEach((String s) -> System.out.println(s));


        // - Streams, much more efficient and concise
        gNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        // - Alternative way
        List<String> sortedGNumbers = bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for(String number : sortedGNumbers){
            System.out.println(number);
        }

        // - Collecting to an arraylist
        List<String> sortedGNumbersArrayList = bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


        Stream<String> ioNumberString = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberString = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberString, inNumberString);
        System.out.println(concatStream.distinct()
                                       .peek(System.out::println)
                                       .count());

        Employee emp1 = new Employee("Ruby Jane", 18);
        Employee emp2 = new Employee("John Jones", 34);
        Employee emp3 = new Employee("Snow White", 22);
        Employee emp4 = new Employee("Loretta Jaimes", 50);
        Employee emp5 = new Employee("Liquor Rhymes", 45);
        Employee emp6 = new Employee("Reed Weller", 27);
        Employee emp7 = new Employee("Jonesses Black", 30);
        Employee emp8 = new Employee("Liberty Osmosis", 38);
        Employee emp9 = new Employee("Stryker Wayne", 60);

        Department accounting = new Department("Accounting Department");
        accounting.addEmployee(emp1);
        accounting.addEmployee(emp2);
        accounting.addEmployee(emp3);
        accounting.addEmployee(emp4);
        accounting.addEmployee(emp5);

        Department hr = new Department("Human Resources");
        accounting.addEmployee(emp6);
        accounting.addEmployee(emp7);
        accounting.addEmployee(emp8);
        accounting.addEmployee(emp9);

        List<Department> departments = new ArrayList<>();
        departments.add(accounting);
        departments.add(hr);

        // - Flat map example, great for when you have nested lists within a list and you want to access all contents instead
        // of having to manually iterate through each nested list. Here we have two departments nested inside a overarching
        // containing list and we want all the employees form the departments inside. Flatmap will allow us to get all employees
        // from each list and return them as a single list to work on. Here we just print them out.
        departments.stream()
                    .flatMap(department -> department.getEmployees().stream())
                    .forEach(System.out::println);

        // - Returns a map that groups employees by their age, so the key is the age value, and the value is all the employees
        // matching that age.
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                                                               .flatMap(department -> department.getEmployees().stream())
                                                               .collect(Collectors.groupingBy(employee -> employee.getAge()));

        // - Find youngest aged employee
        departments.stream()
                   .flatMap(department -> department.getEmployees().stream())
                   .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                   .ifPresent(System.out::println);

        // - Simply finds the age without the employee attached
        Optional<Integer> youngestEmployee = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .map(employee -> employee.getAge())
                .sorted()
                .findFirst();

        System.out.println(youngestEmployee.get());


    }

}
