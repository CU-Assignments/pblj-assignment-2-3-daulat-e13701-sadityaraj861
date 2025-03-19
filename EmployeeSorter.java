import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name; 
	}
	public int getAge() {
		return age;
	}
	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return String.format("%-10s %3d $%,8.2f", name, age, salary);
	}
}

public class EmployeeSorter {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Aditya", 35, 75000));
		employees.add(new Employee("Ayush", 28, 65000));
		employees.add(new Employee("Sachin", 42, 85000));
		employees.add(new Employee("Vikash", 24, 55000));

		Scanner scanner = new Scanner(System.in);
		System.out.println("Sort by:");
		System.out.println("1. Name");
		System.out.println("2. Age");
		System.out.println("3. Salary");
		System.out.print("Enter your choice (1-3): ");
		int criteriaChoice = scanner.nextInt();

		System.out.println("Sort order:");
		System.out.println("1. Ascending");
		System.out.println("2. Descending");
		System.out.print("Enter your choice (1-2): ");
		int orderChoice = scanner.nextInt();

		Comparator<Employee> comparator;

		switch (criteriaChoice) {
		case 1:

			comparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
			break;
		case 2:

			comparator = (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge());
			break;
		case 3:

			comparator = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
			break;
		default:
			System.out.println("Invalid criteria choice! Sorting by name by default.");
			comparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
			break;
		}


		if (orderChoice == 2) {
			comparator = comparator.reversed();
		} else if (orderChoice != 1) {
			System.out.println("Invalid order choice. Defaulting to ascending.");
		}

		employees.sort(comparator);

		System.out.println("\nSorted Employees:");
		System.out.printf("%-10s %3s %8s%n", "Name", "Age", "Salary");
		
		employees.forEach(employee -> {
			System.out.println(employee);
		});
	}
}
