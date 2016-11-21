package examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class file {

	private static Semaphore locker;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
locker = new Semaphore(2);
String filelist[]={
	"/Users/divya/Desktop/osAssignment1.txt",
	"/Users/divya/Desktop/osAssignment1.txt",
	"/Users/divya/Desktop/osAssignment1.txt",
	"/Users/divya/Desktop/osAssignment1.txt"
};
for(int i=0;i<filelist.length;i++){
	new Worker(filelist[i]).start();
}
	}
	
	static class Worker extends Thread{
String name;
		 Worker(String name) {
		this.name=name;
		 }
		 public void run(){
			 try {
				locker.acquire();
				
				FileReader fs = new FileReader(name.trim());
			System.out.println(name);
				Scanner sc = new Scanner(fs);
//				while(sc.nextLine()!= null){
//					String line = sc.nextLine();
//					System.out.println(line);
//				}
				locker.release();
			} catch (InterruptedException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		
	}

}
