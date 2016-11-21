package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BufferedReader r = null;
String currentString;
try {
	r=new BufferedReader(new FileReader("/Users/divya/Desktop/osAssignment1.txt"));
try {
	while ((currentString = r.readLine()) != null){
		System.out.println(currentString);
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
