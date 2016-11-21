package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FirstTry {

	static BufferedReader Bs1 = null;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fs= new FileReader("/Users/divya/Desktop/OsAssignment.txt");
		Scanner sc= new Scanner(fs);
		new FileReaderThread();
		
	}
	
//	First Thread
	static class FileReaderThread extends Thread{
		 public void run(){
		 
		 }
	}
	
//	second Thread
	static class Bufferer extends Thread{
		
	}

//	Third Thread
	static class Printer extends Thread{
		
	}
}
