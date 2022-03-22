package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class GestorAgenda {

    private String nombreArchivo;

    public GestorAgenda(String nombreArchivo) {

        this.nombreArchivo = nombreArchivo;

    }

    public void visualizacion() {

        File f1 = new File(this.nombreArchivo);
        
        String aux;

        try (BufferedReader b1 = new BufferedReader(new FileReader(f1));) {

            while ((aux = b1.readLine()) != null) {
                
                System.out.println(aux);
                
            }

        } catch (FileNotFoundException e){

            e.printStackTrace();

        } catch(IOException i) {

            i.printStackTrace();
        }

    }

    public void añadirPersona(Persona p1) {

        String s1 = p1.getNombre() + "\t" + p1.getNumero() + "\t" + p1.getLugar();

        try (FileWriter fw = new FileWriter(this.nombreArchivo, true); PrintWriter pw = new PrintWriter(fw);){
            pw.println(s1);
            System.out.println("Operación realizada con el mayor exito posible :)");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public Persona busquedaPersona(String nombre) {
        
        Persona p1 = null;
        File f1 = new File(this.nombreArchivo);
        
        int contador = 0;
        
        String aux;

        try (BufferedReader b1 = new BufferedReader(new FileReader(f1));) {

            while (((aux = b1.readLine()) != null) && (contador == 0)) {
                
                if(nombreEnLinea(aux, nombre) == true) {
                    
                    p1 = transformacion(aux);
                    
                    contador++;
                    
                }
                
                
            }
            
          

        } catch (FileNotFoundException e){

            e.printStackTrace();

        } catch(IOException i) {

            i.printStackTrace();
        }
        
        return p1;
        
    }
    
    private boolean nombreEnLinea(String linea, String nombre) {
        
        if(linea.contains(nombre)) {
        	
        	return true;
        	
        }
        else {
        	
        	return false;
        	
        }
        
    }
    
    private Persona transformacion(String aux) {
        
        Persona p1 = new Persona(aux, aux, aux);
        
        String[] arrayLinea = aux.split("\t");
        
        p1.setNombre(arrayLinea[0]);
        p1.setNumero(arrayLinea[1]);
        p1.setLugar(arrayLinea[2]);
        
        
        return p1;
        
    }

    public static void main(String[] args) {

        Persona p1 = new Persona("Asis", "619469457", "Casa");
        Persona p2 = new Persona("Mikel", "45996384", "CasaMikel");

        GestorAgenda g1 = new GestorAgenda("PersonaAgenda.txt");
        g1.añadirPersona(p1);
        g1.visualizacion();
        //g1.busquedaPersona("Asis");
        System.out.println(g1.busquedaPersona("Asis"));

    }

}
