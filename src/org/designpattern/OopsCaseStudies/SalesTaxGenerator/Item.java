import java.util.*;

class Item{

	Category catType ;
	int quantity;
	double priceperItem;
	double finalPrice;
	List<TaxType> taxesToBeConsidered;
	String itemName ;

	Item(Category catType ,String itemName , int quant , double pricepIt ){
		this.catType = catType;
		this.quantity = quant;
		this.priceperItem = pricepIt;
		this.itemName = itemName;
		taxesToBeConsidered = new ArrayList<>();
	}

	public void addTaxesApplicable(TaxType tax){
		taxesToBeConsidered.add(tax);
	}

	@Override
	public String toString() {
		return "Item [catType=" + catType + ", quantity=" + quantity + ", priceperItem=" + priceperItem
				+ ", finalPrice=" + finalPrice + ", taxesToBeConsidered=" + taxesToBeConsidered + ", itemName="
				+ itemName + "]";
	}
	
	
}