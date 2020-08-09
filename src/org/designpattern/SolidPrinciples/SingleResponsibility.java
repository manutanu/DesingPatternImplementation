package org.designpattern.SolidPrinciples;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mritunjay Yadav
 * 
 * SOLID -> Single Responsibility Principle says that one class should have only one responsibility 
 * like Ex- if we have a Product class then it should be responsible for only adding new Products 
 * It should not be perisiting data because persistence should be handled in other class 
 *
 */
// This class is responsible for adding products and printing products
class  Products {
	
	private List<String> productsList = new ArrayList<>();
	
	public void addNewProduct(String productname , int productprice) {
		productsList.add(productname +" : "+productprice);
	}
	
	public String printProducts() {
		return productsList.toString();
	}
}

// this class only have one responsibility to save Products List in persistence datastore 
class ProductPersistence {
	
	public String saveProducts(Products products) {
		// saved products 
		return products.printProducts();
	}
}

public class SingleResponsibility {

	public static void main(String[] args) {
		Products productList = new Products();
		productList.addNewProduct("Apple",4);
		productList.addNewProduct("Bananan", 4);
		productList.addNewProduct("Khana", 5);
		ProductPersistence repo = new ProductPersistence();
		System.out.println(repo.saveProducts(productList));

	}

}
