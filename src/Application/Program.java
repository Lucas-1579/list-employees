package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id already taken. Try again: ");
				id = sc.nextInt();
			}

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			Employee p = new Employee(id, name, salary);
			list.add(p);
			System.out.println();
		}
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idSalary = sc.nextInt();
		Integer pos = position(list,idSalary);

		if (pos == null) {
			System.out.println("This id does not exist!");
			System.out.println();
		}

		else {
			System.out.print("Enter the percentage: ");
			Double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
			System.out.println();
		}

		System.out.println("List of employees:");
		for (Employee x : list) {
			System.out.println(x);
		}

		sc.close();

	}

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee e = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return e != null;
	}

}
