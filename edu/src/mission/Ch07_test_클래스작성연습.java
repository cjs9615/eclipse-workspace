package mission;

class Person {
	private int pid; 
	private String name;
	private int age;
	
	public Person(int pid, String name, int age) {
		this.pid = pid; this.name = name; this.age = age;
	}
	public String toString() {
		return pid +":" + name + ":" + age;
	}
}
class Student extends Person {
	private int sid; 
	private String dept;
	private int year;
	
	public Student(int pid, String name, int age, int sid, String dept, int year) {
		super(pid, name, age); this.sid = sid; this.dept = dept; this.year = year;
	}
	public String toString() {
		return super.toString() + ":" + sid + ":" + dept + ":" + year;
	}
}
class Employee extends Person {
	private int eno; 
	private String dept;
	private int salary;
	
	public Employee(int pid, String name, int age, int eno, String dept, int salary) {
		super(pid, name, age); this.eno = eno; this.dept = dept; this.salary = salary;
	}
	public String toString() {
		return super.toString() + ":" + eno + ":" + dept + ":" + salary;
	}
}
public class Ch07_test_클래스작성연습 {
	public static void main(String[] args) {
		Person arr[] = new Person[5];
		arr[0] = new Student(19901111, "Kim", 22, 2010000, "Elec", 2);
		arr[1] = new Student(19902222, "Lee", 25, 2010111, "Computer", 3);
		arr[2] = new Student(19903333, "Park", 24, 2010222, "Korean", 4);
		arr[3] = new Employee(19904444, "Lee", 30, 22222, "RND", 4000);
		arr[4] = new Employee(19905555, "Yoon", 38, 33333, "Manager", 8500);
		
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
