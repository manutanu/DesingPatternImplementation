package org.designpattern.SolidPrinciples;


/**
 * @author Mritunjay Yadav
 *
 *	Interface Segregation Principle says segregate an Interface into smaller interfaces in such a way that if a developer 
 *	wants a specific funcionality in the interface he/she did not necesarrily implement the interface which contains 
 *	unnecessary methods , which he/she doesn't want to implement 
 *
 */

interface Document{}

// So basically this big interface hav print , scan , fax functionalities so if someone want to only use print functionality 
// the he needs to give implementation for all of the other methods too which is bad 
// so what we will do is segregate this into smaller interfaces
interface Machine{
	
	public void print(Document doc);
	public void scan(Document doc);
	public void fax(Document doc);
	
}

interface Print{
	
	public void print(Document d);
}

interface Scan{
	public void scan(Document d);
}

// so in this we need to create a PhotoCopy machine which will scan and print both 
// so we can use both of the interfaces 
// or we can create a new interface out of both of them 
class PhotoCopier implements Print , Scan {

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

interface MultiFuntionalDevice extends Print , Scan {
	
}

class MultiFunctionalMachine implements MultiFuntionalDevice {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}


public class InterfaceSegregation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
