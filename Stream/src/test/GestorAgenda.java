package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GestorAgenda {
	private String nombre;

		public GestorAgenda(String nombre) {
		super();
		this.nombre = nombre;
	}
		
		
		void visualizacion(String[] args) throws IOException {
			if (args.length != 1) {
				 System.out.println("Esta vacio");
				}
				else{
					System.out.println("Examinando");
					try(FileInputStream file = new FileInputStream (args[0]);){
						//InputStream ins = new FileInputStream("C:\\Drive\\Learn.txt");
				        Scanner obj = new Scanner(file);
				        while (obj.hasNextLine())
				            System.out.println(obj.nextLine());

					}catch(FileNotFoundException e) {
						System.err.println("Erroooor");
					}
				}

		}
		
		void addPerson(String[] args, Persona p1) throws IOException {
			if (args.length != 1) {
				 System.out.println("Esta vacio");
				}
				else{
					System.out.println("Examinando");
					try(FileInputStream file = new FileInputStream (args[0]);){
						FileWriter fileWriter = new FileWriter("agenda.txt", true);
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.newLine();
						bw.write(p1.nombre +" "+ p1.numero+" "+ p1.lugar);
						bw.close();
					}catch(FileNotFoundException e) {
						System.err.println("Erroooor");
					}
				}
		}
		
		public String busquedaPersona(String[] args, Persona p1) throws IOException {
			String str = ";";
			int line= nombreEnLinea(args, p1);

			String person = transformation(args, line);
			
			return str;
		}




		private String transformation(String[] args, int line) {
			
			return null;
		}


		private int nombreEnLinea(String[] args, Persona p1) throws IOException {
			BufferedReader fe = new BufferedReader(new FileReader(this.nombre));
			//System.out.println(fe.readLine());
			int line = 0;
			int n = 0;
			while(fe.readLine() != null) {
				if(fe.readLine().contains(p1.nombre)) {
					line = n;
					n++;
				}
				n++;
			}
			return line;
		}


		public static void main(String[] args) throws IOException {
			GestorAgenda g1 = new GestorAgenda("agenda.txt");
			Persona p1 = new Persona("Maik", 659874123, "Ñoñosti");
			g1.visualizacion(args);
			//g1.addPerson(args, p1);
			g1.busquedaPersona(args, p1);
			
			
		}
				
}
