import java.util.*;

class Basket{


	List<Item> listOfItems ;

	Basket(){
		this.listOfItems = new ArrayList<>();
	}

	public void addItemsToBasket(Item item){
		this.listOfItems.add(item);
	}

	public List<Item> getItemsList(){
		return this.listOfItems;
	}
}