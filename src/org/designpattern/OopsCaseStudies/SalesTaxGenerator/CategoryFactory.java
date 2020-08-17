class CategoryFactory{

	static int uuid = 0;

	public Category createCategory(String categoryName){
		return new Category(++uuid , categoryName);
	}

}