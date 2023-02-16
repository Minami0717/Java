package _20221017;

class Employee {
	private String name;
	private double salary;
	int age;
	
	Employee(String name, double salary, int age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	private double getSalary() {
		return salary;
	}
	
	int getAge() {
		return age;
	}
}
