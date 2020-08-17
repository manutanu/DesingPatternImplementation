import java.util.*;

class ImportTax extends TaxType{

	ImportTax(double taxpercen){
		this.taxName = "IMPORT";
		this.taxpercentage = taxpercen;
		this.expemtedCategories = new ArrayList<>(); 
		this.categoriesToBeConsider = new ArrayList<>();
	}
}