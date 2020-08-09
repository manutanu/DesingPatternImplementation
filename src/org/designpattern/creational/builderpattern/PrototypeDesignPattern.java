package org.designpattern.creational.builderpattern;

// Proxy design pattern includes creating copy of partially or completely initialized object 
// and then make changes in to the copied version to make different object
class Employee{
	
	String personName;
	String personDesignation;
	Address address ;
	
	public Employee(String personName, String personDesignation, Address address) {
		super();
		this.personName = personName;
		this.personDesignation = personDesignation;
		this.address = address;
	}
	
	// copy constructor
	public Employee deepCopy() {
		return new Employee(this.personName ,personDesignation , address.deepCopy() );
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonDesignation() {
		return personDesignation;
	}
	public void setPersonDesignation(String personDesignation) {
		this.personDesignation = personDesignation;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [personName=" + personName + ", personDesignation=" + personDesignation + ", address="
				+ address + "]";
	}
}

class Address{
	
	String addresstext;
	int zipcode ;
	
	public Address(String addresstext, int zipcode) {
		super();
		this.addresstext = addresstext;
		this.zipcode = zipcode;
	}
	
	public Address deepCopy() {
		return new Address(addresstext , zipcode);
	}
	
	public String getAddresstext() {
		return addresstext;
	}
	public void setAddresstext(String addresstext) {
		this.addresstext = addresstext;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [addresstext=" + addresstext + ", zipcode=" + zipcode + "]";
	}
	
	
}

public class PrototypeDesignPattern {

	public static void main(String[] args) {
		Address address = new Address("A-4 himgiri colony ", 244001);
		Employee person = new Employee("Mritunjay" , "Sr. Software Developer",address);
		
		System.out.println(person.toString());
		
		Employee newEmployee = person.deepCopy();
		newEmployee.setPersonDesignation("Software developer");
		newEmployee.setPersonName("Tanuj");
		System.out.println(newEmployee.toString());
	}

}
