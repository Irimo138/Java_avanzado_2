package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class inputStream_test {

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			 System.out.println("Esta vacio");
			}
			else{
				System.out.println("Examinando");
				try(FileInputStream file = new FileInputStream (args[0]);){
					int count = 0;
					int data = file.read();
					while(data != -1) {
						count++;
						data = file.read();
					}
				}catch(FileNotFoundException e) {
					System.err.println("Erroooor");
				}
			}

	}

}
