package Entities;

public class Employee {
	
	private Integer id;
	private String name;
	private Double salary;
	
	
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public void increaseSalary(Double percent) {
		salary += salary * percent / 100.0;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public String toString() {
		return    id
				+ ", "
				+ name
				+ ", "
				+ String.format("%.2f", salary);
	}
	

}
