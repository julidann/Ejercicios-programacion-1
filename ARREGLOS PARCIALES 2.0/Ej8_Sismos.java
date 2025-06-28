public class Ej8_Sismos{
    final static int MAX=21,SEPARADOR=0;
    public static void main (String [] args){
        double [] arrS = {0, 2.1, 1.5, 4.1, 0, 3.4, 0, 2.5, 3.0, 0, 3.8, 0, 2.7, 2.7, 3.9, 2.5, 0, 4.2, 2.0, 0, 0};
        
        System.out.println("arreglo original");
        mostrarArrelgo(arrS);
        procesarSismos(arrS);
        

    }
    public static void procesarSismos (double [] arrS){ 
        int ini=0;
        int fin=-1;
        int dias=1;
        int N=2;
        double M=2.6;
        double promedio=0;
        boolean loEncontre=false;

        while (ini<MAX&&!loEncontre){
            ini=buscarInicio(arrS, fin+1);
            if (ini<MAX){
                fin=buscarFin(arrS, ini);
                int tamanio= fin - ini +1;
                if (tamanio>=N){
                    promedio=calcularPromedio(arrS, ini, fin, tamanio);
                    if (promedio>M&&!loEncontre){
                        System.out.println("\nEl día con el promedio más alto de sismos fue " + dias + " con un promedio de " + promedio + " simsos");
                        loEncontre=true;
                    }
                } 
            }
            dias++;
        }
    }
    public static double calcularPromedio(double [] arr, int ini, int fin, int tamanio){
        double suma = 0;
        
        for (int i = ini; i <= fin; i++) {
            suma += arr[i];
        }
        return suma / (fin - ini + 1);
    }
    



     
        
    public static int buscarInicio(double [] arr, int pos){
        while (pos<MAX && arr[pos]==0){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (double [] arr, int pos){
        while (pos<MAX && arr[pos] !=0){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (double [] arr){
        for (int pos = 0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
}
