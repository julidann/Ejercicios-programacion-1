public class Ej2_AsignacionMesas{
    final static int MAXC= 20, MAXM=5, SEPARADOR = 0;
    public static void main(String[] args) {

        int [] arrComensales={4, 3, 8, 6, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        int [] arrMesas={2,3,5,6,12};

        asignacionDeMesas(arrComensales,arrMesas);
        
        mostrarArreglo(arrComensales, MAXC);
        System.out.println(" ");
        mostrarArreglo(arrMesas, MAXM);
        
    }
    public static void asignacionDeMesas (int [] arrComensales, int [] arrMesas) {
    int pos =0;
    int mesaYaAsignada=0;
    int cliente=1;
    while (pos<MAXC && arrComensales[pos] != SEPARADOR && mesaYaAsignada<MAXM){
        if (mesaYaAsignada == MAXM){
            System.out.println("No hay mas mesas para asignar");
        }else {
            int nroMesa= buscarMesa (arrMesas, arrComensales[pos]);
            if (nroMesa== -1){
                System.out.println("Al comensal" + cliente + "no se le pudo asignar ninguna mesa");
            }else{
                System.out.println("Al comensal " + cliente + " se le asignó la mesa " + nroMesa);
                eliminarComensal(arrComensales);
                arrMesas[nroMesa]=-arrMesas[nroMesa];
                
            }
        }
            mesaYaAsignada++;
                cliente++;
    }
}
  

    public static int buscarMesa(int arrM[], int numero){
        int pos =0;
        
        while (pos<MAXM && arrM[pos]<numero){
            pos++;
        }
        if (pos<MAXM){
            return pos;
        }else{
            return -1;
        }
    }
    public static void eliminarComensal (int [] arrC){
        for (int pos = 0 ; pos<MAXC-1; pos++){
            arrC[pos] = arrC[pos+1];
        }
    }
    public static void mostrarArreglo (int [] arr, int MAX){
        for (int pos=0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }

    }
}





        