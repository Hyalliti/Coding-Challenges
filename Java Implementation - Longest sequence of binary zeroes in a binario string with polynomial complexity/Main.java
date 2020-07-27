import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream; 
import java.lang.*; 
import java.util.regex.*; 

class Main {
  public static void main(String[] args) {
    // Entrada de datos:
    Scanner scan = new Scanner(System.in);
    // VARIABLE DECLARATION
    // LIST: N,H,P,cadena_zero, i, gap
    System.out.print("Ingrese el entero a obtener el Binary Gap:  ");
    int N = scan.nextInt();
    solution(N);
  }

  public static void print(String[] args){
    System.out.println(args);
  }

  public static void solution(int N){
  /////////////////////////////////////////////////////////////////////
  // Casos menores a 9 y funcion dec2bin
  ////////////////////////////////////////////////////////////////////
    if (N < 9) {
        if (N==5) {
          System.out.println("Binary Gap is: " + 1);
        }else{
          System.out.println("Binary Gap is: " + 0);
        }    
    }
    
    else{
      String binario = "";
          int r=0;

          do
            {
              r=N%2;
              N=N/2;
              binario = binario + r;
            }while(N>=1);
          binario = binario;
          System.out.println("Binario: " + new StringBuilder(binario).reverse().toString());
          binario = new StringBuilder(binario).reverse().toString();

      /////////////////////////////////////////////////////////////////////
      // Manejo de la cadena de bits
      ////////////////////////////////////////////////////////////////////
      
      int gap = 0;
      int longitud = binario.length();
      int lastElement = binario.charAt(longitud-1);
      String[] cadena_zero = new String[longitud+1];
      int[] P = new int[longitud+1];

      int[] index = new int[longitud+1];
      cadena_zero[0] = "0";
      // Extract the substring, save the substring, skip the substring

      for (int i = 0; i < longitud ; i++) 
      {
        cadena_zero[i+1] = cadena_zero[i] + "0";      
      }

      for (int i = 0; i < longitud ; i++) {
        // Create a matcher, this would be the P in the previous code, utilizando a P se puede saber hasta donde llega la cadena máxima. Más tarde, se utilizará P para conocer el último valor válido de la cadena:
        Pattern pattern = Pattern.compile(cadena_zero[i]); 
        Matcher matcher = pattern.matcher(binario);  
        if (matcher.find() == true){
          P[i] = i;
        }
        else{ P[i] = longitud;} 
      }
      // P es Homólogo de H.find(cadena_zero[gap-1])
      for (int i = 0; i <  longitud ; i++){
        if(P[i] == 0){gap = 0;}
        if(P[i] < longitud){gap += 1;}
        else {}
      }
        Pattern pattern = Pattern.compile(cadena_zero[gap-1]); 
        Matcher matcher = pattern.matcher(binario); 

        // Utilizando lo mas cercano a expresiones regulares se limpia la cadena binario siempre que su último caracter sea 0, si resulta el caso que la cadena más larga ocupa ese lugar, se elimina y reemplaza por cualquier otra cadena en su lugar.
        int checker = 1;
        if(binario.charAt(binario.length()-1) == '0' & (binario.split(cadena_zero[gap-1],-1).length - 1) <= 1) {
          do{
            // Si y solo si, al evaluar que el patron de 0's de cadena_zero se repite al menos una vez en una posicion no validada, se procede a limpiar la cadena
            System.out.println("Binary Gap to be reduced is:"+ binario);
            StringBuilder b = new StringBuilder(binario);
            b.replace(binario.lastIndexOf(cadena_zero[gap-1]), binario.lastIndexOf(cadena_zero[gap-1]) + 1, "" );
            binario = b.toString();

            gap = gap-checker;
            checker += 1;
            gap = gap-1;
          }while(matcher.find() == true & binario.charAt(binario.length()-1) == '0' & gap != 0);
        }
        else{
          System.out.println("Binary Gap is: "+ gap);
        }
      }
    }
}


  

  