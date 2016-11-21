package examples;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	private static Semaphore locker;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
locker = new Semaphore(2);
String names[]={
	"abi",
	"divya",
	"doran",
	"mike"
};
for(int i=0;i<names.length;i++){
	new Worker(names[i],(int)(4*Math.random())).start();
}
	}
	
	static class Worker extends Thread{
String name;
int num;
		 Worker(String name, int num) {
		this.name=name;
		this.num=num;
		 }
		 public void run(){
			 try {
				locker.acquire();
				for(int i=0;i<num;i++){
					System.out.println(this.name+"worker");
					Thread.sleep(50);
				}
				locker.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		
	}

}
