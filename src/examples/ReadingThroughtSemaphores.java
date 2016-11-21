package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ReadingThroughtSemaphores {

	public static Semaphore s;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		
BufferedReader Bs = null;
s=new Semaphore(2);
String s1;
Bs=new BufferedReader(new FileReader("/Users/divya/Desktop/osAssignment1.txt"));
while((s1=Bs.readLine()) != null){
new Printer(s1).start();
}

	}

	static class Printer extends Thread{
		String s1;
		 Printer(String s1){
			this.s1=s1;
		}
		 
		 public void run(){
			 try {
				s.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
System.out.println(s1);
s.release();
		 }
		
	}
}
