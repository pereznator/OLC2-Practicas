
package olc2.practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

public class OLC2Practica1 {

    public static void main(String[] args) throws IOException, Exception {
        escribirMenu();
        //generarSintactico("C:/Users/jorge/Documents/USAC DOCUMENTS/Primer Semestre 2022/Compi 2/Laboratorio/practicas/OLC2-Practica1/src/olc2/practica1");
    }
    
    public static void escribirMenu() throws IOException, Exception {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una de las siguientes opciones");
            System.out.println("1. Ingresar ruta de archivo a analizar");
            System.out.println("2. Salir");
            int opcion = scan.nextInt();
            if (opcion == 1) {
                leerRuta();
            }else if (opcion == 2) {
                break;
            }else {
                System.out.println("Opcion invalida. \n");
            }
        }
    }
    
    public static void leerRuta() throws IOException, Exception {
        /*Scanner rutaScanner = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo de texto: ");
        String ruta = rutaScanner.nextLine();
        File archivo = new File("C:\\Users\\jorge\\Documents\\USAC DOCUMENTS\\Primer Semestre 2022\\Compi 2\\Laboratorio\\practicas\\OLC2-Practica1\\entrada.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            String total = "";
            while(((linea = br.readLine()) != null)) {
                total += linea + "\n";
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            Logger.getLogger(OLC2Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Reader lector = null;
        try {
            lector = new BufferedReader(new FileReader("C:/Users/jorge/Documents/USAC DOCUMENTS/Primer Semestre 2022/Compi 2/Laboratorio/practicas/OLC2-Practica1/entrada.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
            Logger.getLogger(OLC2Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lector == null) {
            return;
        }
        LexerPractica lexer = new LexerPractica(lector);
        Sintactico parser = new Sintactico(lexer);
        parser.parse();
    }
    
    public static void generarSintactico(String ruta) {
        try {
            String[] instrucciones = {"-destdir", ruta, "-parser", "Sintactico", ruta+"/gramatica.cup"};
            java_cup.Main.main(instrucciones);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
