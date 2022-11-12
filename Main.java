package com.comparableInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = List.of(
				new Employee(1, "jeevi", 21, 300000),
				new Employee(2, "jee", 26, 450000),
				new Employee(3, "Aii", 32, 900000));
				
		employees.stream().
		sorted((first, second) -> first.getName().compareTo(second.getName())).
		forEach(employee -> System.out.println( "OrderedEmployee : " + employee.getName()));
		
		employees.stream().
		filter(employee -> employee.getAge()> 30).
		forEach(employee -> System.out.println(employee.toString()));
		
		Object salary = employees.stream().
		map(employee -> employee.getSalary()).
		reduce((sum,emp) -> sum+emp );
		System.out.println( "FullEmployeeSalary1 = " +salary);
		
		int salary1 = employees.stream().
			collect(Collectors.summingInt(employee -> employee.getSalary()));
		System.out.println("FullEmployeeSalary2 = " + salary1);
		
		Employee maxSalary = employees.stream().
				max((salary2, salary3) -> salary2.getSalary() > salary3.getSalary() ? 1:-1).
				get();
				
		System.out.println( "MaxSalary = " + maxSalary);
		
		Employee minSalary = employees.stream().
				max((salary2, salary3) -> salary2.getSalary() < salary3.getSalary() ? 1:-1).
				get();
				
		System.out.println( "MinSalary = " + minSalary);
		
		System.out.println(employees.toString());
				
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("a", "1"));
		customers.add(new Customer("b", "2"));
		customers.add(new Customer("c", "3"));
		System.out.println(customers.toString());
		
	//	Collections.sort((List<Customer>) customers);
	}
}
