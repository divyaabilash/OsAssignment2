package examples;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class Approachwithfile {

	public static Semaphore s;
	static BufferedReader Bs,Bs1;
	static Integer firstbufferlength,secondbufferlength;
	static String line1 ="",line2,line3;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException{
		FileReader fs=new FileReader("/Users/divya/Desktop/osAssignment1.txt");
		Scanner scan = new Scanner(fs);
		s=new Semaphore(2);
		String s1;
		//scanning for each line of the file
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			ExecutorService ex = Executors.newCachedThreadPool();
			
			//calling the class findwords
			Future<String> string1 = ex.submit(new Process1(line));
			System.out.print(string1.toString());
		}
	}

	
	static class Process1 implements Callable<String>{

		String line,buffereddata,data;
		public Process1(String line) {
			this.line = line;
		}

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			int count =0;
			while(line!=null){
				InputStream is = new ByteArrayInputStream(line.getBytes());
//				read it to buffer reader
				Bs = new BufferedReader(new InputStreamReader(is));
				while((data = Bs.readLine())!= null && count ==0){
//					System.out.println(buffereddata);
				buffereddata = data;
				}
				count++;
			}
			return buffereddata;
		}
		
	}
}
