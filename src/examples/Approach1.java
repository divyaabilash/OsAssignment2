package examples;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Approach1 {

	public static Semaphore s;
	static BufferedReader Bs,Bs1;
	static StringBuffer sBuffer, sBuffer1 ;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		FileReader fs=new FileReader("/Users/divya/Desktop/osAssignment1.txt");
		Scanner scan = new Scanner(fs);
		s=new Semaphore(3);
		String s1;
		//scanning for each line of the file
		while(scan.hasNextLine()){
			String line = scan.nextLine();
//			System.out.println(line);
			new Process1(line).start();
			new Process2(sBuffer).start();
//			System.out.println(sBuffer1);
			new Process3(sBuffer1).start();
		}
	}
	
	static class Process1 extends Thread{
		String line,line1;
		public Process1(String line) {
			this.line =line;
		}
		public void run(){
			try {
				s.acquire();
				
//				converting string to inputstream
				InputStream is = new ByteArrayInputStream(line.getBytes());
//				read it to buffer reader
				Bs = new BufferedReader(new InputStreamReader(is));
				sBuffer = new StringBuffer("");
				while ((line1 = Bs.readLine()) != null) {
					sBuffer.append(line1);						
				}		
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
			s.release();
		}
		
		
	}
	
	static class Process2 extends Thread{

		StringBuffer local;
		int count = 0;
		public Process2(StringBuffer sBuffer) {
			local = sBuffer;
		}

		public void run(){
			try {
				s.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while(local!=null && count == 0){
			sBuffer1 = local;
//			System.out.println(sBuffer1);
			count++;
		}
		s.release();
		}
		
	}
	
	static class Process3 extends Thread{
       StringBuffer s3;
		public Process3(StringBuffer sBuffer1) {
			s3= sBuffer1;
		}
		
		public void run(){
			try {
				s.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(s3);
			s.release();
		}
	}
	
	
	
}
