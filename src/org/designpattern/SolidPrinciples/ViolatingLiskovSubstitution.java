package org.designpattern.SolidPrinciples;



/**
 * @author Mritunjay Yadav
 *	
 *	Liskov Substitution principle says if you have an object of a superclass then you should be able to substitute object
 *  of its subClass without breaking the application 
 *  
 *  so lets see how Liskov Substitution principle can be broken 
 *  So possible implementation for liskov sobstituion proinciple by using Factory Desing Pattern
 *  
 */
// SuperClass 
class Rectangle {
	
	protected int width , height ;
	
	public Rectangle() {}
	
	public Rectangle(int height , int width) {
		this.width = width;
		this.height = height;
	}
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getAread() {
		return width * height;
	}
}

// SubClass 
class Square extends Rectangle {
	
	
	public Square() {}
	
	public Square(int size) {
		// TODO Auto-generated constructor stub
		width = height = size;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
		super.setWidth(height);
	}

	@Override
	public int getAread() {
		// TODO Auto-generated method stub
		return super.getAread();
	}
	
}

class ShapeFactory{
	
}

public class ViolatingLiskovSubstitution {

	public static void main(String[] args) {
		
		// So here we substitued subClass Square object into SuperClass Rectangle object 
		// So result will not be the same as we expected them to be this is what Liskov Substituion Principle 
		// tries to mention
		Rectangle rectangle = new Rectangle(10 , 5);
		useIt(rectangle);
		Rectangle square = new Square();
		square.setWidth(10);
		useIt(square);

	}
	
	// So here we have fetched height first then we set width which in case of square will also set height internally but there
	// is no way to know that its a sqaure thats why we have wrong output 
	public static void useIt(Rectangle r) {
		int height = r.getHeight();
		r.setWidth(5);
		System.out.println(r.getAread() +"  "+(height*5));
		
	}

}
