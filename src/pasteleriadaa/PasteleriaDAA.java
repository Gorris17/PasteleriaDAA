/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleriadaa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author FernandoC
 */
public class PasteleriaDAA {
    private static int  pasteleros; //pasteleros (filas)
    private static int pasteles; //tipos de pastel (columnas)
    private static int[][] tablaBeneficios;
    private static int[] pedido;
    private static int[] resultado;
    private static int beneficio;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        cargar("entrada.txt");
        resultado = new int[]{1,1,2,3,1};
        beneficio = 30;
//        if (args[1] != null) 
            guardar("salidda.txt");
//        else mostrarPantalla();
    }
    public static void cargar(String fichero) throws FileNotFoundException, IOException{
        //Fichero del que vamos a leer
        String[] aux;
        try{
            FileReader f = new FileReader(fichero);
            BufferedReader b = new BufferedReader(f);
        
            //Leemos el contenido el fichero
            aux = b.readLine().split(" ");
            pasteleros = Integer.parseInt(aux[0]);
            pasteles = Integer.parseInt(aux[1]);
            tablaBeneficios = new int[pasteleros][pasteles];
            pedido = new int[pasteleros];
            for (int i = 0; i < pasteleros; i++) {
                aux = b.readLine().split(" ");
                for (int j = 0; j < pasteles; j++) {
                    tablaBeneficios[i][j]=Integer.parseInt(aux[j]);
                }
            }
            aux = b.readLine().split(" ");
            System.out.println("funciona3");
            for (int i = 0; i < pasteleros; i++) {
                pedido[i] = Integer.parseInt(aux[i]);
            }
            b.close();
        } catch (Exception ex) {
            System.out.println("Error Entrada: "+ ex.getMessage());
        }
    }
    
    public static void guardar(String fichero) throws IOException{
        //Comprobamos si el fichero existe
        File archivo = new File(fichero);
        BufferedWriter bw;
        if (archivo.exists()) {
            System.err.println("El fichero de salida ya existe");
        } else {
            try{
                bw = new BufferedWriter(new FileWriter(archivo));
                for (int i = 0; i < pedido.length; i++) {
                    bw.write(resultado[i] + ",");
                }
                bw.write("\n");
                bw.write(beneficio);
                bw.close();
            } catch (Exception ex) {
                System.err.println("Error Salida: " + ex.getMessage());
            }
        }
    }

    private static void mostrarPantalla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
