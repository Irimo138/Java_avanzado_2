package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GestorAgenda2 {
	private String nombre;

		public GestorAgenda2(String nombre) {
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
		
		public String busquedaPersona(String nombre) throws IOException {
			Persona p = null;
			
			try(BufferedReader br = new BufferedReader(new FileReader(this.nombre))){
				Boolean personaEncontrada = false;
				String Linea = br.readLine();
				while(Linea != null && personaEncontrada == false) {
					if(nombreEnLinea(Linea, nombre)) {
						
					}
				}
			}
			String person = transformation(0);
			return person;
		}




		private String transformation(int line) throws IOException {
			String Person = "";
			int cont = 0;
			BufferedReader fe = new BufferedReader(new FileReader(this.nombre));
			while(fe.readLine() != null) {
				if(cont == line) {
					Person = fe.readLine();
				}
				cont++;
			}
			fe.close();
			return Person;
		}


		private boolean nombreEnLinea(String linea, String nombre2) throws IOException {

		        try (BufferedReader b1 = new BufferedReader(new FileReader(this.nombre));) {

		            

		            }

		        } catch (FileNotFoundException e){

		            e.printStackTrace();

		        } catch(IOException i) {

		            i.printStackTrace();
		        }
				return -1;

		}


		public static void main(String[] args) throws IOException {
			GestorAgenda g1 = new GestorAgenda("agenda.txt");
			Persona p1 = new Persona("Maik", 659874123, "Ñoñosti");
			Persona p2 = new Persona("Iri", 688824053, "Tolosa");
			g1.visualizacion(args);
			//g1.addPerson(args, p1);
			System.out.println(" ");
			System.out.println(g1.busquedaPersona(p1));
			
			
		}
				
}
