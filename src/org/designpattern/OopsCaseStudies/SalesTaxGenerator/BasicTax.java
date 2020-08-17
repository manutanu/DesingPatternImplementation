import java.util.*;

class BasicTax extends TaxType{

	BasicTax(double taxpercen){
		this.taxName = "BASIC";
		this.taxpercentage = taxpercen;
		this.expemtedCategories = new ArrayList<>(); 
		this.categoriesToBeConsider = new ArrayList<>();
	}
}