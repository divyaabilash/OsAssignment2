package examples;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

import examples.ReadingThroughtSemaphores.Printer;

public class Reading2 {

	private static final int MAX_CONCURRENT_THREADS = 2;
    private final static Semaphore crunchifyAdminLOCK = new Semaphore(MAX_CONCURRENT_THREADS, true);
    static BufferedReader Bs1 = null;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
BufferedReader Bs = null;

String s1;
Integer size;
Bs=new BufferedReader(new FileReader("/Users/divya/Desktop/osAssignment1.txt"));
while((s1=Bs.readLine()) != null){
//	creating a thread for putting the line in the buffer
	size=new Printer(s1).call();
	System.out.println(size);
}

	}

	static class Printer implements Callable<Integer>{
		String s1;
		 Printer(String s1){
			this.s1=s1;
		}

		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			 try {
				 crunchifyAdminLOCK.acquire();
//				System.out.println(s1);
				// convert String into InputStream
				InputStream is = new ByteArrayInputStream(s1.getBytes());
				// read it with BufferedReader
				Bs1 = new BufferedReader(new InputStreamReader(is));
				
				String line;
				while ((line = Bs1.readLine()) != null) {
					System.out.println(line);
				}

			 crunchifyAdminLOCK.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s1.length();
		}
		
	}
	
}
