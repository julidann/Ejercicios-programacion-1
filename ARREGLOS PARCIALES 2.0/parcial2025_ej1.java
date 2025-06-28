public class parcial2025_ej1 {
    public static final int MAX=25;
    public static void main(String[] args) {
        int [] arrT ={-6,-8,23,21,20,19,15,-1,15,14,13,16,-8,-10,30,28,22,16,12,-3,56,52,54,60,-5};

        System.out.println("Arreglo Original");
        mostrarArrelgo(arrT);
        recorrerSecuencia(arrT);
        System.out.println("Arreglo modificado");
        
        mostrarArrelgo(arrT);

        
    }
    public static void recorrerSecuencia (int [] arrT){
        int ini=0;
        int fin=-1;
        int estudiante=0;
        

        while (ini<MAX){
            ini=buscarInicio(arrT, fin+1);
            if (ini<MAX){
                fin=buscarFin(arrT, ini);
                boolean secuenciaDescendente = secuenciaDescendente (arrT, ini, fin);
                if (!secuenciaDescendente){

                int minutosTotales= sumarSecuencia (arrT ,ini, fin);
                int horas=convertirHoras(minutosTotales);
                int minutos=convertirMinutos(minutosTotales);
                eliminarYModificarSecuencia(arrT, ini, fin, minutos,horas);
                fin=fin+2;
                }else{
                    System.out.println("el estudiante"+estudiante+ "no se concentró");
                }

        }
        estudiante++;
    }
    
}
public static void correrIzquierda (int [] arrT, int pos){
        for (int i = pos ; i<MAX-1; i++){
            arrT[i] = arrT[i+1];
        }
    }
    public static void eliminarYModificarSecuencia (int [] arrT, int ini, int fin, int minutos, int horas){
        while (ini<=fin){
            correrIzquierda(arrT, fin);
            fin--;
            ;
        }
            arrT[ini]=horas;
            arrT[ini+1]=minutos;
    }
    
    public static int convertirHoras (int minutosTotales){
        int minutos=60;
        int hora= minutosTotales/minutos;
        return hora;
    }
    public static int convertirMinutos(int minutosTotales){
        int minutos=60;
        int min= minutosTotales%minutos;
        return min;
    }
    public static boolean secuenciaDescendente (int [] arrT, int ini, int fin){
        boolean esDescendente=false; 
        while (ini<=fin && !esDescendente){ 
            esDescendente=arrT[ini]> arrT[ini+1];
            ini++;
        }
        return esDescendente;
    }
        /*boolean esDescendente = true;
    for (int i = ini; i < fin && esDescendente; i++) {
        esDescendente = arrT[i] > arrT[i + 1];
    }
    return esDescendente;
    } */
    public static int sumarSecuencia (int [] arrT, int ini, int fin){
        int suma = 0;
        for (int i=ini; i<=fin; i++){
            suma+=arrT[i];
        }
        return suma;
    }

    public static int buscarInicio(int [] arr, int pos){
        while (pos<MAX && arr[pos]<0){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (int [] arr, int pos){
        while (pos<MAX && arr[pos] >0){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (int [] arr){
        for (int pos = 0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
    
}
