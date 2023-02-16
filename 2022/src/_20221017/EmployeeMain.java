package _20221017;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee e = new Employee("김진호", 3000, 0);
		//e.salary = 300;
		
		e.age = 26;
		
		String s = e.getName();
		int a = e.getAge();
	}

}
