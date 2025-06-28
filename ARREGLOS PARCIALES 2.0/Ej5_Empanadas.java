public class Ej5_Empanadas{
    final static int MAXE=16,ROQUEFORT=7;
    public static void main (String [] args){
        int [] arrE = {-1, 5, 5, 7, 7, -6, 4, 9, 10, -4, 1, 1, 2, 7, -9, -8};
        
        System.out.println("arreglo original");
        mostrarArrelgo(arrE);
        pedidosEmpanadas(arrE);
        

    }
    public static void pedidosEmpanadas (int [] arrE){ 
        int ini=0;
        int fin=-1;
        int pedidoInsertar=2;
        int pedido=1;

        while (ini<MAXE){
            ini=buscarInicio(arrE, fin+1);
            if(ini<MAXE){
                fin=buscarFin(arrE, ini);
                if (pedido == pedidoInsertar){
                    insertarEmpanadas(arrE, ini, fin, ROQUEFORT);
                    pedido++;
                }else{
                    pedido++;
                    }
                }
            }
            System.out.println("\nArreglo con pedido");
            mostrarArrelgo(arrE);
        }

    public static void insertarEmpanadas(int [] arr, int ini, int fin, int valor){
        while (ini <= fin && arr[ini] < valor) {
            ini++;
        }
        correrDerecha(arr, ini);
        arr[ini]=ROQUEFORT;
       
        }
    
    public static void correrDerecha (int[] arrE, int pos){
        for (int i= MAXE-1; i>pos; i--){
            arrE[i]= arrE[i-1];
        }
    }
        
        
    public static int buscarInicio(int [] arr, int pos){
        while (pos<MAXE && arr[pos]<0){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (int [] arr, int pos){
        while (pos<MAXE && arr[pos] > 0){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (int [] arr){
        for (int pos = 0; pos<MAXE; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
}
