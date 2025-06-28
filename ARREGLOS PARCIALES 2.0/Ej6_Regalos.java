public class Ej6_Regalos{
    final static int MAXP=28,MAXR=2, SEPARADOR=0;
    public static void main (String [] args){
        int [] arrP= {0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int [] arrR= {44,6};
        System.out.println("Arreglos originales");
        mostrarArrelgo(arrP, MAXP);
        System.out.println(" ");
        mostrarArrelgo(arrR, MAXR);

        productosRecibidos(arrP, arrR);
        System.out.println(" ");
        mostrarArrelgo(arrP, MAXP);

    }
    public static void productosRecibidos (int [] arrP, int [] arrR){
        int ini=0;
        int fin=-1;
        int pedidos =0;

        while (ini<MAXP){
            ini=buscarInicio(arrP, fin+1 );
            if (ini<MAXP){
                fin=buscarFin (arrP, ini);
                regalarProductos(arrP,ini,fin,arrR);
                fin = fin+2; // le modifico el fin +2 porque siempre sumo dos productps
                pedidos++;
                
            }
            
            
        }
        System.out.println( "La cantidad total de productos regalados fue " + (pedidos*MAXR));
    } 
    public static void regalarProductos (int [] arrP, int ini, int fin, int [] arrR){
        for (int pos =0; pos<MAXR; pos++){
            insertarProducto (arrP, ini, fin, arrR[pos]);
        }
    }
    public static void insertarProducto (int [] arrP, int ini, int fin, int valor){
        while (ini<=fin && arrP[ini]<valor){
            ini++;
        }
        correrDerecha (arrP, ini);
        arrP[ini]=valor;
    }
    public static void correrDerecha(int [] arrP, int pos){
        for (int i= MAXP-1; i>pos; i--){
            arrP[i]=arrP[i-1];
        }
    }

public static int buscarInicio(int [] arr, int pos){
        while (pos<MAXP && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (int [] arr, int pos){
        while (pos<MAXP && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (int [] arr, int MAX){
        for (int pos = 0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
}
