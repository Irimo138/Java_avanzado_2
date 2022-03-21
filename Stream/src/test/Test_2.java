package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_2 {
	
	
	public static void main(String[] args) throws IOException {
		//FileOutputStream myFileSt = new FileOutputStream( "2.txt" );
		if (args.length != 1) {
			 System.out.println("Esta vacio");
			}
			else{
				System.out.println("Examinando");
				try(FileInputStream file = new FileInputStream (args[0]);){
					try (FileOutputStream fos = new FileOutputStream("copia.txt")) {
						byte[] data =  new byte[512];
						int bytesLeidos = file.read(data);
						while(bytesLeidos != -1) {
							fos.write(data, 0, bytesLeidos);
							bytesLeidos = file.read(data);
						}
						System.out.println("Se iso la magia");
					}
				}catch(FileNotFoundException e) {
					System.err.println("Erroooor");
				}
			}

		
	}
}
