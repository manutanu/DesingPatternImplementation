package org.designpattern.structural.staticProxy;

public class ImageProxy implements Image {

	private BitmapImage bitImage ;
	private int xcache ;
	private int ycache ;
	private String nameCache;
	
	ImageProxy(String name){
		this.nameCache = name;
	}
	
	@Override
	public int getCoordinates() {
		System.out.println("logs ---------- Get coordinates method called ------------");
		if(bitImage != null) {
			return bitImage.getX() + bitImage.getY();
		}else {
			return xcache + ycache;
		}
	}

	@Override
	public void setCoordinates(int x, int y) {
		System.out.println("logs ---------- Set coordinates method called ------------");
		if(bitImage != null) {
			bitImage.setX(x);
			bitImage.setY(y);
		}else {
			xcache = x;
			ycache = y;
		}
	}

	@Override
	public void render() {
		System.out.println("logs ---------- Render method called on image ------------");
		if(bitImage != null) {
			bitImage.render();
		}else {
			bitImage = new BitmapImage(nameCache);
			bitImage.setX(xcache);
			bitImage.setY(ycache);
			bitImage.render();
		}
		
	}

}
