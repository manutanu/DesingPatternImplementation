import java.util.*;

class ItemFactory{

	List<TaxType> taxes;
	List<Category> categories;

	ItemFactory(List<TaxType> taxes , List<Category> categories){
		this.taxes = taxes;
		this.categories = categories;
	}

	public Item createItemInstance(String categorystring , int quantity , String itemName , double priceper , boolean importflag){
		System.out.println(categorystring +"  "+ quantity +" "+ itemName +" "+ priceper +" "+ importflag);
		Category itemCat = selectProperCategory(categorystring);
		System.out.println(itemCat.categoryName);
		Item itemm =  new Item(itemCat , itemName , quantity , priceper );
		addTaxesApplyed(itemm , importflag );
		return itemm;
	}

	public void addTaxesApplyed(Item item , boolean importflag){

		for(int i=0;i<taxes.size();i++){
			// if item is imported then add import tax for the item 
			if(importflag == true && taxes.get(i).taxName.equals("IMPORT")){
				item.addTaxesApplicable(taxes.get(i));
			}

			// iterate over every tax and its Exempted categories if items category doesnt lie inside exempted category that mean 
			// we should add the tax for the item 
			for(Category cat : taxes.get(i).expemtedCategories) {
				if(cat.categeoryId != item.catType.categeoryId){
					item.addTaxesApplicable(taxes.get(i));
				}
			};
		}
		
	}

	public Category selectProperCategory(String categoryString){
		Category cat = null ;
		Category other = null;
		for(int i=0;i<categories.size();i++){
			if(categories.get(i).categoryName.toLowerCase().equals(categoryString.toLowerCase())){
				cat =  categories.get(i);
				break;
			}

			if(categories.get(i).categoryName.toLowerCase().equals("OTHERS"))
				other = categories.get(i);
		}

		if(cat == null){
			return other;
		} else
			return cat;
	}
}