public class Ej4_Supermercado{
    final static int MAXP=25,MAXT=2,SEPARADOR=0,R=22,C=2;
    public static void main (String [] args){
        int [] arrP = {0, 0, 12, 9, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0};
        int [] arrT= {8,9};
        mostrarArrelgo(arrP);
        System.err.println(" ");
        asignarProductos(arrP, arrT);
        mostrarArrelgo(arrP);
    }

    public static void asignarProductos (int [] arrP, int[] arrT){
        int ini=0;
        int fin=-1;
        int asignado=0;
        int nroPedido=1;

        while (ini<MAXP && asignado<C){
            ini=buscarInicio(arrP, fin+1);
            if (ini<MAXP){
                fin=buscarFin (arrP, ini);
                boolean contieneProducto= contieneProducto(arrP,ini,fin,arrT);
                    if (contieneProducto){
                       insertarProducto(arrP, ini, fin);
                       System.out.println("Producto asignado en pedido " + nroPedido);
                        asignado++;
                        nroPedido++;
                    }else{
                        System.out.println("No se pudo insertar Producto en pedido " + nroPedido);
                        nroPedido++;
                    }
                    }
                }
                System.out.println("No quedan mas productos para asignar");
    }
        
    public static boolean contieneProducto(int[] arrP, int ini, int fin, int[] arrT) {
        for (int i = ini; i <= fin; i++) {
            if (sonIguales(arrT,arrP[i] )) {
            return true;
            }
        }
    return false;
}
   public static boolean sonIguales( int[] arrT, int valor) {
    for (int pos = 0; pos < MAXT; pos++) {
        if (arrT[pos] == valor) {
            return true;
        }
    }
    return false;
}

    public static void insertarProducto (int [] arrP, int ini, int fin){
            correrDerecha(arrP, fin);
            arrP[fin+1]=R;
        }
    public static void correrDerecha (int[]arr, int pos){
        for (int i= MAXP-1; i>pos ; i--){
            arr[i]=arr[i-1];
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
    public static void mostrarArrelgo (int [] arr){
        for (int pos = 0; pos<MAXP; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
}
