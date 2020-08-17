import java.util.*;

class TaxType {

	double taxpercentage;
	String taxName ;
	List<Category> expemtedCategories;
	List<Category> categoriesToBeConsider;

	public void addCategoryToBeExempted(Category cat){
		expemtedCategories.add(cat);
	}

	public void addCategoryToBeConsidered(Category cat){
		categoriesToBeConsider.add(cat);
	}

	public void removeCategoryToBeExempted(String catName){
		for(int i=0;i<expemtedCategories.size();i++){
			if(expemtedCategories.get(i).categoryName.toLowerCase().equals(catName.toLowerCase())){
				expemtedCategories.remove(i);
				break;
			}
		}
	}

	public void removeCategoryToBeConsidered(String catName){
		for(int i=0;i<categoriesToBeConsider.size();i++){
			if(categoriesToBeConsider.get(i).categoryName.toLowerCase().equals(catName.toLowerCase())){
				categoriesToBeConsider.remove(i);
				break;
			}
		}
	}
}