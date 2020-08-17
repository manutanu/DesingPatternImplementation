
import java.util.*;

class BasketTotalCostCalculator {

	public double calculateTotalCostOfBucket(Basket basket){
		List<Item> items = basket.getItemsList();
		double totalcost = 0.0;
		for(int i=0;i<items.size();i++){
			totalcost += calculateFinalCostForThisItem(items.get(i));
		}

		return totalcost;
	}

	public double calculateFinalCostForThisItem(Item item){
		double priceWithOutTax = item.quantity * item.priceperItem;
		double totalamout = priceWithOutTax;
		for(TaxType tax : item.taxesToBeConsidered){
			totalamout += (priceWithOutTax * tax.taxpercentage)/100;
		};
		item.finalPrice = totalamout;
		return totalamout;
	}
}