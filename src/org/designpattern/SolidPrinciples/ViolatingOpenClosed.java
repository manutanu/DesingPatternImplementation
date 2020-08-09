package org.designpattern.SolidPrinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum Color{
	RED ,
	GREEN ,
	BLUE
}

enum Size {
	SMALL ,
	MEDIUM ,
	LARGE
}

/**
 * @author Mritunjay Yadav
 *	OpenClosed principle says the class which is already tested and deployed should be open for extension but closed for modification
 *	that means if you want to do some changes you should not change already tested or deployed files for that . there are many ways to achieve it
 *	most famous way to make changes in logic without modifying actual classes logic Open Closed principle can be ensured by using 
 *	Specification Design Pattern 
 *	
 *	but in this file we will violate Open-CLosd principle and in other file FollowingOpenClosed we will do things according to 
 *	Open-Closed principle
 */
class Product {
	
	private String name ;
	private Color color ;
	private Size size ;
	
	
	public Product(String name, Color color, Size size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", color=" + color + ", size=" + size + "]";
	}
	
}

class ProductFilter {
	
	// filtering on the basis of Color and deploy application 
	public Stream<Product> filterProductByColor(List<Product> productList , Color color){
		return productList.stream().filter(prod -> prod.getColor() == color);
	}
	
	// now boss says we should add filtering on the basis of Size So will write new filter method in the same 
	// class which is not recommended atall and violates Opend-CLosed principle 
	public Stream<Product> filterProductBySize(List<Product> productList , Size size){
		return productList.stream().filter(prod -> prod.getSize() == size);
	}
	
	// now boss says we should add filtering on the basis of Size So will write new filter method in the same 
		// class which is not recommended atall and violates Opend-CLosed principle 
	public Stream<Product> filterProductBySizeAndColor(List<Product> productList , Size size , Color color){
		return productList.stream().filter(prod -> prod.getSize() == size && prod.getColor() == color);
	}
	
}

public class ViolatingOpenClosed {
	
	public static void main(String[] args) {
		List<Product> productList = new ArrayList<>();
		Product apple = new Product("Apple",Color.RED , Size.SMALL);
		Product mango =  new Product("Mango" , Color.GREEN , Size.MEDIUM);
		Product house = new Product("House" , Color.BLUE , Size.LARGE);
		productList.add(apple);
		productList.add(mango);
		productList.add(house);
		
		ProductFilter filter = new ProductFilter();
		filter.filterProductByColor(productList, Color.RED).forEach(product -> System.out.println(product.toString()));
		
		filter.filterProductByColor(productList, Color.GREEN).forEach(product -> System.out.println(product.toString()));
		
		// now boss came and said we should provide filtering on the basis of Color AND Size 
		filter.filterProductBySizeAndColor(productList , Size.LARGE , Color.BLUE  ).forEach(product -> System.out.println(product.toString()));
	
	}	

}
