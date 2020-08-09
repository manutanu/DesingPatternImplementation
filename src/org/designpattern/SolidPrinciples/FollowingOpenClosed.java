package org.designpattern.SolidPrinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Mritunjay Yadav
 *	OpenClosed principle says the class which is already tested and deployed should be open for extension but closed for modification
 *	that means if you want to do some changes you should not change already tested or deployed files for that . there are many ways to achieve it
 *	most famous way to make changes in logic without modifying actual classes logic Open Closed principle can be ensured by using 
 *	Specification Design Pattern 
 *  
 *  So to implement Specification Design Pattern we have to create Specification Interface which specify the criteria 
 *  on which we want to filter like Color , Size etc
 *  And one interface for Filter<> which then we can use to implement for different kind of filters
 *  	
 */

// anyone can implement this interface to implement different specifications for items
interface Specification<T> {
	
	// this will return true if item follows Particular specification
	public boolean isSatisfied(T item);
	
}

// anyone can implement this filter interface for implementing different filters
interface Filter<T> {
	
	public Stream<T> filter(List<T> itemList , Specification<T> spec);

}

//create some specification implementations
class ColorSpecification implements Specification<Product>{

	private Color color ;
	
	public ColorSpecification(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean isSatisfied(Product item) {
		return item.getColor() == color;
	}
	
}

//create some Size specification implementations
class SizeSpecification implements Specification<Product>{

	private Size size;
	
	public SizeSpecification(Size size) {
		this.size = size;
	}
	
	@Override
	public boolean isSatisfied(Product item) {
		return item.getSize() == size;
	}
	
}

class AndSpecification implements Specification<Product>{

	private Specification<Product> left , right ;
	
	public AndSpecification(Specification<Product> left, Specification<Product> right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return left.isSatisfied(item) && right.isSatisfied(item);
	}
	
}

class BetterFilter implements Filter<Product>{

	@Override
	public Stream<Product> filter(List<Product> itemList, Specification<Product> spec) {
		return itemList.stream().filter(item -> spec.isSatisfied(item));
	}
	
}

public class FollowingOpenClosed {

	public static void main(String[] args) {
		List<Product> productList = new ArrayList<>();
		Product apple = new Product("Apple",Color.RED , Size.SMALL);
		Product mango =  new Product("Mango" , Color.GREEN , Size.MEDIUM);
		Product house = new Product("House" , Color.BLUE , Size.LARGE);
		productList.add(apple);
		productList.add(mango);
		productList.add(house);
		
		BetterFilter betterfilter = new BetterFilter();
		betterfilter.filter(productList, new ColorSpecification(Color.GREEN)).forEach(item -> System.out.println(item.toString()));
		betterfilter.filter(productList, new ColorSpecification(Color.RED)).forEach(item -> System.out.println(item.toString()));
		
		// So now boss came and ask you that we should provide filtering on the basis of size too .
		// So now you dont have to modify already tested and deployed classes 
		// you can create new Specification implementation for Size and we will be good to go 
		betterfilter.filter(productList, new SizeSpecification(Size.SMALL)).forEach(item -> System.out.println(item.toString()));
		betterfilter.filter(productList, new SizeSpecification(Size.MEDIUM)).forEach(item -> System.out.println(item.toString()));
		
		// now your boss came and ask you to create a filter on the basis of size and color both too 
		// still you have already created Specification for Color and Size you 
		// just have to create one new Specification that can combine both specifications 
		betterfilter.filter(productList, new AndSpecification(new ColorSpecification(Color.BLUE ) ,new SizeSpecification(Size.LARGE)))
		.forEach(item -> System.out.println(item.toString()));
	}

}
