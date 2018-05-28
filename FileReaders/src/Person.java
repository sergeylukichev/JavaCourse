import java.io.Serializable;

public class Person implements Serializable{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public int getAge() {
		return age;
	}
}
