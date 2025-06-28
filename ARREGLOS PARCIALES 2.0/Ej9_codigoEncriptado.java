public class Ej9_codigoEncriptado{
    final static int MAXM=17, MAXC=3;
    final static char SEPARADOR=' ';
    public static void main (String [] args){
        char [] arrMensaje = {' ', 'h','o','l','a',' ','c','o','m','o',' ','e','s','t','a','s',' '};
        int [] arrCodigo={1,2,3};

        System.out.println("mostrar mensaje original");
        mostrarArrelgo(arrMensaje);

        recorrerMensaje(arrMensaje, arrCodigo);
        System.out.println("\nMostrar mensaje encriptado");
        mostrarArrelgo(arrMensaje);
        
        
    }
    public static void recorrerMensaje (char[]arrM, int[]arrC){
        int ini=0;
        int fin=-1;
        int posClave=0;
        
    while (ini < MAXM){
        ini = buscarInicio(arrM, fin + 1);
        if (ini < MAXM){
            fin = buscarFin(arrM, ini);
            posClave = encriptarMensaje(arrC, arrM, ini, fin,posClave);
        }
    }
}
public static int encriptarMensaje(int[] arrC, char[] arrM, int ini, int fin, int posClave ){
    int tamanio = fin - ini + 1;
    int i=ini;
    while (tamanio>MAXC && i<=fin){
        arrM[i] = (char) (arrM[i] + arrC[posClave]);
            posClave++;
            if (posClave == MAXC) { 
                posClave = 0;
            }
    i++;
}
return posClave;
}
    /*int tamanio = fin - ini + 1;
    if (tamanio > MAXC) { 
        for (int i = ini; i <= fin; i++) {
            arrM[i] = (char) (arrM[i] + arrC[posClave]);
            posClave++;
            if (posClave == MAXC) { 
                posClave = 0; 
            }
        }
    }
    return posClave; }*/

    public static int buscarInicio(char [] arr, int pos){
        while (pos<MAXM && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (char [] arr, int pos){
        while (pos<MAXM && arr[pos] !=SEPARADOR){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (char [] arr){
        for (int pos = 0; pos<MAXM; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
}
