import java.util.*;
import java.io.*;

public class TaxGeneratorCompany{

	static StringTokenizer stk = new StringTokenizer("");
	static BufferedReader bf = new  BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws Exception {

		// first create Categories list for the system 
		CategoryFactory catFactory = new CategoryFactory();
		Category food = catFactory.createCategory("FOOD");
		Category medical = catFactory.createCategory("MEDICAL");
		Category books = catFactory.createCategory("BOOK");
		Category others = catFactory.createCategory("OTHERS");
		List<Category> categories = Arrays.asList(new Category[]{food , medical , books , others});
		

		// create TaxTypes Import and Basic 
		TaxType importTax = new ImportTax(5);
		TaxType basicTax = new ImportTax(10);
		basicTax.addCategoryToBeExempted(food);
		basicTax.addCategoryToBeExempted(medical);
		basicTax.addCategoryToBeExempted(books);
		List<TaxType> taxes = Arrays.asList(new TaxType[]{ importTax , basicTax });

		// create Items and Bucket 
		ItemFactory itemFactory = new ItemFactory(taxes , categories);
		System.out.println("Please Enter your Cart Elements");
		System.out.println("Format Of Input Should be itemQuantity itemName itemCategoryName(in Caps) perItemPrice importFlag");
		System.out.println("For Example --> 2 Chocolate FOOD 20.0 FALSE");
		System.out.println("How many items do you have");
		int N = Integer.parseInt(bf.readLine());
		Basket basket = new Basket();

		while(N-->0) {
			stk = new StringTokenizer(bf.readLine());
			int quant = Integer.parseInt(stk.nextToken());
			String itemName = stk.nextToken();
			String itemCategoryName = stk.nextToken();
			double itemperprice = Double.parseDouble(stk.nextToken());
			String importFlag = stk.nextToken();
			basket.addItemsToBasket(
				itemFactory.createItemInstance(itemCategoryName , quant , itemName ,
				 itemperprice , (importFlag.toUpperCase().equals("FALSE") ? false : true)));
		}

		basket.getItemsList().forEach(item -> {
			System.out.println(item);
		});

			
		BasketTotalCostCalculator basketCalculator = new BasketTotalCostCalculator();
		System.out.println(basketCalculator.calculateTotalCostOfBucket(basket));
		basket.getItemsList().forEach(item -> {
			System.out.println(item);
		});
		// process Bucket and final response

	}
}