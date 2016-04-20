
package pasteleriadaa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PasteleriaDAA {
    private static int          pasteleros; //pasteleros (filas)
    private static int          pasteles; //tipos de pastel (columnas)
    private static int[][]      tablaBeneficios;
    private static int[]        pedido;
    private static LinkedList<Integer>        resultado;
    private static int          beneficio;

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            cargar(args[0]);
            RyP();
            if (args.length == 2) 
                guardar(args[1]);
            else mostrarPantalla(); 
        } else System.err.println("Introduce fichero de entrada.");
        
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
//        if (archivo.exists()) {
//            System.err.println("El fichero de salida ya existe");
//        } else {
            try{
                bw = new BufferedWriter(new FileWriter(archivo));
                for (int i = 0; i < resultado.size() - 1; i++) {
                    bw.write(resultado.get(i) + ",");
                }
                bw.write(Integer.toString(resultado.get(resultado.size() - 1)));
                bw.newLine();                
                bw.write(Integer.toString(beneficio));
                bw.close();
            } catch (Exception ex) {
                System.err.println("Error Salida: " + ex.getMessage());
            }
//        }
    }

    private static void mostrarPantalla() {
        for (int i = 0; i < resultado.size()-1; i++) {
            System.out.print(resultado.get(i) + ",");
        }
        System.out.println(resultado.get(resultado.size()-1));
        System.out.println(beneficio);
    }

    
    public static void RyP(){
        int     cotaInferior  =   0;
        Nodo    sol           =   new Nodo();
        Nodo    solFin        =   new Nodo();
        
        for (int i = 0; i < pasteleros; i++) {
            solFin.getSol().add(i+1);
            cotaInferior+=tablaBeneficios[i][pedido[i]-1];
        }
        
        PriorityQueue q = new PriorityQueue();
        q.add(sol);
        while (!q.isEmpty()) {
            sol = (Nodo) q.peek();
            q.remove();  
            if (esSolucion(sol)) {
                if (sol.getBeneficio() > cotaInferior) {
                    solFin=sol;
                    cotaInferior=sol.getBeneficio();
                }
            } else if (cotaSuperior(sol) >= cotaInferior) {
                for (Nodo n : complecciones(sol)) {
                    if (cotaSuperior(n)>= cotaInferior && esFactible(n)) {
                        q.add(n);
                    }
                }
            } 
        }
        beneficio=solFin.getBeneficio();
        resultado = solFin.getSol();
    }

    private static boolean esSolucion(Nodo sol) {
        return sol.getNivel()==pasteleros;
    }

    private static int cotaSuperior(Nodo sol) {
        int aux = sol.getBeneficio() + sol.getPeso();
        for (int i = sol.getNivel(); i < pasteleros; i++) {
            aux+=tablaBeneficios[i][pedido[i]-1];
        }
        return aux;
    }

    private static LinkedList<Nodo> complecciones(Nodo sol) {
        LinkedList<Nodo> aux = new LinkedList();
        int nivel = sol.getNivel() + 1;
        int beneficio = sol.getBeneficio() + sol.getPeso();
        for (int i = 0; i < pasteleros; i++) {   
            if (!sol.getSol().contains(i)){
                int peso = tablaBeneficios[i][pedido[nivel - 1]]; //revisar el nivel
                int nombre = i+1;
                Nodo n = new Nodo(nivel, beneficio, peso, nombre);
                LinkedList<Integer> solucion = new LinkedList();
                solucion = (LinkedList<Integer>) sol.getSol().clone();
                solucion.add(i);
                n.setSol(solucion);
                aux.add(n);
            }
        }
        return aux;
    }

    private static boolean esFactible(Nodo n) {
        return true;
    }
        
}