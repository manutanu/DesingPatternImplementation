
public abstract class  Rover{

	public Direction headTowards ;
	public int currentX;
	public int currentY;


	public Direction getHeadTowards(){
		return headTowards;
	}

	public void setHeadTowards(Direction dir){
		this.headTowards = dir;
	}

	public int getCurrentX(){
		return currentX;
	}

	public void setCurrentX(int x){
		this.currentX = x;
	}

	public int getCurrentY(){
		return currentY;
	}

	public void setCurrentY(int y){
		this.currentY = y;
	}

	public abstract void moveForward();
	public abstract void rotate(char dir);
	public abstract void rotateUtilRight();
	public abstract void rotateUtilLeft();

	@Override
	public String toString() {
		return "Rover [headTowards=" + headTowards + ", currentX=" + currentX + ", currentY=" + currentY + "]";
	}
	
	
}