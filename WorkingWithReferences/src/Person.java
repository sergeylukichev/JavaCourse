
public class Person {
	String fname;
	String lname;
	
	public Person(Person person) {
		this.fname = person.fname;
		this.lname = person.lname;
	}
	
	public Person(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public int hashCode() {
		final int prime = 42;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return fname.equals(other.fname) && lname.equals(other.lname);
	}

	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + "]";
	}
}
