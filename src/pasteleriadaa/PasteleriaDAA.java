/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleriadaa;
import java.io.File;
import java.io.FileWriter;
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
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static void cargar(String fichero){
        //Fichero del que vamos a leer
        File f = new File(fichero);
        Scanner s = null;
        String[] args;
        try{
            //Leemos el contenido el fichero
            s = new Scanner (f);

            args = s.nextLine().split(" ");
            pasteleros = Integer.parseInt(args[0]);
            pasteles = Integer.parseInt(args[1]);

            for (int i = 0; i < pasteles; i++)
                for (int j = 0; j < pasteleros; j++) {
                    args=s.nextLine().split(" ");
                    tablaBeneficios[j][i]=Integer.parseInt(args[i]);
                }
            args=s.nextLine().split(" ");
            for (int i = 0; i < pasteleros; i++) {
                pedido[i] = Integer.parseInt(args[i]);
            }
        } catch (Exception ex) {
            System.out.println("Mensaje:"+ ex.getMessage());
        } finally {
            try {
                if(s != null) s.close();
            } catch (Exception ex2){
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }
    
    public static void guardar(String fichero){
        String aux = "";
        for (int x : resultado) {
            aux = x + ",";
        }
        FileWriter fich = null;
        try {
            fich = new FileWriter(fichero);
            fich.write(aux + "\n");
            fich.write(beneficio);
            fich.close();
        } catch (Exception ex) {
            System.out.println("Mensaje de la excepcion: " + ex.getMessage());
        }
    }

}
