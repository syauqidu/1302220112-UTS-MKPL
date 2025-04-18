package lib;

import java.util.LinkedList;
import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;

	private boolean isForeigner;
	private Gender gender; // true = Laki-laki, false = Perempuan

	private Person spouse;

	private List<Person> children;

	public Person(String firstName, String lastName, String idNumber, String address, boolean isForeigner,
			Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.isForeigner = isForeigner;
		this.gender = gender;
		this.children = new LinkedList<>();
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public void addChild(Person child) {
		this.children.add(child);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getAddress() {
		return address;
	}

	public boolean isForeigner() {
		return isForeigner;
	}

	public Gender getGender() {
		return gender;
	}

	public Person getSpouse() {
		return spouse;
	}

	public List<Person> getChildren() {
		return children;
	}

}
