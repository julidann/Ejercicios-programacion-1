public class Ej1_imagenes{
    final static int MAXM= 20, SEPARADOR = 0;
    public static void main(String[] args) {
        int [] arrImg = {0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0};
        
        System.out.println("Arreglo Original");
        mostrarArreglo(arrImg);

        int ini=0;
        int fin=-1;
        
        int tamanio=0;
        int x=3;
        while (ini<MAXM){
            ini=buscarInicio(arrImg, fin+1);
                if(ini<MAXM){
                    fin= buscarFin (arrImg, ini);
                    tamanio= fin-ini+1;
                    if (tamanio>x&& sonIguales(arrImg,ini,fin,tamanio)){
                        comprimirImagen(arrImg,ini,fin,tamanio);
                        fin=ini+2;
                    }
                }
            }
            System.out.println("\nArreglo Comprimido");
            mostrarArreglo(arrImg);
        }

    public static boolean sonIguales (int [] arr, int ini, int fin, int tamanio){
        boolean sonIguales=true;
        while (ini<fin&&sonIguales){
            sonIguales=arr[ini]==arr[ini+1];
            ini++;
        }
        return sonIguales;
        
        /*boolean sonIguales=false;
        while (ini<fin&&!sonIguales){
            if (arr[ini]!=arr[ini+1]){
            return false;
            //ini++;
        }else{
            sonIguales=true;
        }
        ini++;
        }
        return true;*/
            
    }
    public static void comprimirImagen (int [] arr, int ini, int fin, int tamanio){
        for (int i=ini; i<fin-1; i++){
            correrIzquierda(arr, ini+1);
        }
        arr[ini]=-tamanio;
    }
    public static int buscarInicio(int [] arr, int pos){
        while  (pos<MAXM && arr[pos] == 0){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (int [] arr, int pos){
        while (pos<MAXM && arr[pos]!=0){
            pos++;
        }
        return pos -1;
    }
    public static void mostrarArreglo (int [] arr){
        for (int pos=0; pos<MAXM; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    public static void correrIzquierda (int [] arr, int pos){
        for (int i=pos; i<MAXM-1; i++){
            arr[i]= arr[i+1];
        }
    }
}