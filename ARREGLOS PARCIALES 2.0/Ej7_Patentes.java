public class Ej7_Patentes{
    final static int MAX=25;
    final static char SEPARADOR=' ';
    public static void main (String [] args){
        char [] arrI= {' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ','P', 'R', 'G', '0', '1', '0', ' ', 'A', 'B', '9', '8', '7', 'E', 'X', ' ', ' ' };
        char [] arrE= {' ', ' ', 'A', 'B', '9', '8', '7', 'E', 'X', ' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ','F', 'O', 'R', '0', '0', '1', ' ' };
        char[] arrNoE = new char[MAX]; // No egresaron
        char[] arrNoI = new char[MAX]; // No ingresaron
        //int posNoE = 0;
        //int posNoI = 0;


        System.out.println("Arreglos originales");
        mostrarArrelgo(arrI);
        System.out.println(" ");
        mostrarArrelgo(arrE);

        recorrerPatentes(arrE, arrI, arrNoI);
        recorrerPatentes(arrI, arrE, arrNoE);

       System.out.println("\nArreglos actualizados");
        mostrarArrelgo(arrNoI);
        System.out.println(" ");
        mostrarArrelgo(arrNoE);
    }

    public static void recorrerPatentes (char [] arrA, char [] arrB, char [] arrNOB){
        int iniA=0;
        int finA=-1;
        int finNo=1;
        
        while (iniA<MAX){ //busca inicio fin patentes A
            iniA=buscarInicio(arrA, finA+1);
            if (iniA<MAX){
                finA=buscarFin(arrA, iniA);
                
                boolean encontrada=false;
                int iniB=0;
                int finB=-1;

                while (iniB<MAX){  //busca inicio fin patentes B
                iniB=buscarInicio(arrB, finB+1);
                    if (iniB<MAX){
                    finB=buscarFin(arrB, iniB);

                    if (compararContenidoPatente (arrA, iniA, finA, arrB, iniB, finB)){ // SI SON IGUALES
                        encontrada=true;
                    }
                }
            }
            if (!encontrada){ // SI NO SON IGUALES, LA MANDA AL NUEVO ARREGLO
                finNo = enviarPatenteAnuevoArrelgo(arrA, iniA, finA, arrNOB, finNo);
            }
        }
    }
}

    public static boolean compararContenidoPatente(char[] arrA, int iniA, int finA, char[] arrB, int iniB, int finB) {
    boolean sonIguales=false;
    int tamanioA=finA-iniA+1;
    int tamanioB=finB-iniB+1;
        if (tamanioA==tamanioB) { // COMPARA EL TAMANIO
            while (iniA<=finA&&arrA[iniA]==arrB[iniB]) { // CONTINUA SI SON IGUALES
                iniA++;
                iniB++;
                }
                if (finA<iniA) { // SI SON DISTINTAS, O FIN ES MAYOR A INICIO
                sonIguales=true; // SON IGUALES
                }
        }
        else{
            sonIguales=false;
                
            }
        return sonIguales;
    }
    
public static int enviarPatenteAnuevoArrelgo(char[] arrA,  int iniA, int finA, char [] arrNo, int finNo) {
    while (iniA<=finA) {
            arrNo[finNo]=arrA[iniA];
            finNo++;
            iniA++;
            }
        return finNo;
    }
        
    public static int buscarInicio(char [] arr, int pos){
        while (pos<MAX && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (char [] arr, int pos){
        while (pos<MAX && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (char [] arr){
        for (int pos = 0; pos<MAX; pos++){
            System.out.print("| " + arr[pos]);
        }
    }
    
}
