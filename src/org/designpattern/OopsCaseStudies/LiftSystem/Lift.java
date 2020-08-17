import java.util.*;

class Lift extends Thread{

	int liftId ;
	int currentfloor ;
	Queue<Integer> upward;
	Queue<Integer> downward;
	int maxcapacity ;
	int currentcapacity ;


	public void addElement(){

	}

	public void run() {
		try{
			Thread.sleep(1000);
			processQueue();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void processQueue(){
		ExecutorService  pool = Executors.newFixedThreadPool(4);
		pool.execute(new Lift());
	}
}