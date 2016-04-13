
package pasteleriadaa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasteleriaDAA {
    private static int  pasteleros; //pasteleros (filas)
    private static int pasteles; //tipos de pastel (columnas)
    private static int[][] tablaBeneficios;
    private static int[] pedido;
    private static int[] resultado;
    private static int beneficio;

    public static void main(String[] args) throws IOException {
        cargar(args[0]);
        resultado = new int[]{1,1,2,3,1};
        beneficio = 30;
        if (args.length == 2) 
            guardar(args[1]);
        else mostrarPantalla();
    }
    public static void cargar(String fichero) throws FileNotFoundException, IOException{
        String[] aux;
        try{
            FileReader f = new FileReader(fichero);
            BufferedReader b = new BufferedReader(f);

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
            for (int i = 0; i < pasteleros; i++) {
                pedido[i] = Integer.parseInt(aux[i]);
            }
            b.close();
        } catch (IOException | NumberFormatException ex) {
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
                for (int i = 0; i < resultado.length - 1; i++) {
                    bw.write(resultado[i] + ",");
                }
                bw.write(Integer.toString(resultado[resultado.length - 1]));
                bw.newLine();                
                bw.write(Integer.toString(beneficio));
                bw.close();
            } catch (Exception ex) {
                System.err.println("Error Salida: " + ex.getMessage());
            }
        }
    }

    private static void mostrarPantalla() {
        for (int i = 0; i < resultado.length-1; i++) {
            System.out.print(resultado[i] + ",");
        }
        System.out.println(resultado[resultado.length-1]);
        System.out.println(beneficio);
    }

}
