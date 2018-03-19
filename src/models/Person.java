package models;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private Integer age;

	public Person() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.age = 0;
	}

	public Person(String firstName, String lastName, String address, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
	}

	public Person(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.address = person.getAddress();
		this.age = person.getAge();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getAddress() {
		return this.address;
	}

	public Integer getAge() {
		return this.age;
	}

}
