public class Ej3_AsignacionAulas {
    public static final int MAXM=20, MAXA=3, SEPARADOR=0;
    public static void main(String[] args) {
        int [] arrMaterias = {0, 0, 34, 2, 12, 25, 0, 32, 55, 12, 3, 88, 14, 0, 0, 17, 36, 19, 0, 0};
        int [] arrAulas = {2, 3, 6};

        designarAulas(arrMaterias, arrAulas);
        mostrarArreglo(arrMaterias, MAXM);
        System.out.println(" ");
        mostrarArreglo(arrAulas, MAXA);


    }
    public static void designarAulas (int [] arrM, int[] arrA){
        int ini=0;
        int fin =-1;
        int aulaYaAsignada=0;
        int materia=1;

        while (ini<MAXM /*&& aulaYaAsignada<MAXA*/){
            ini=buscarInicio (arrM, fin + 1);
            if (ini<MAXM){
                fin=buscarFin (arrM, ini);
                int tamanio=fin-ini+1;
                if (aulaYaAsignada==MAXA){
                    System.out.println("No quedan mas aulas por asignar");
                }else{
                    int nroAula=buscarAula (arrA, tamanio);
                    if (nroAula==-1){
                        System.out.println("No se le pudo asignar aula a la materia " + materia);
                    }else{
                        System.out.println("A la materia " + materia + " se le asignó el aula " + nroAula);
                        eliminarMateria (arrM, ini, fin);
                        arrA[nroAula]=-arrA[nroAula];
                        fin = ini;
                    }
                }
            }
            aulaYaAsignada++;
            materia++;
        }

    }
    
    public static int buscarAula (int [] arrA, int valor){
        int pos=0;
        while (pos<MAXA && arrA[pos]<valor){
            pos++;
        }
        if (pos<MAXA){
            return pos;
        }
        else{
            return -1;
        }
    }
    public static void eliminarMateria (int [] arrM, int ini, int fin){
        while (ini<=fin){
            correrIzquierda(arrM, ini);
            fin--;
        }
    }
    public static void correrIzquierda (int arr[], int ini){
        for (int i=ini; i<MAXM-1; i++){
            arr[i] = arr[i+1];
        }
    }
    public static int buscarInicio (int[]arr, int pos){
        while (pos<MAXM && arr[pos] ==SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (int[]arr, int pos){
        while (pos<MAXM && arr[pos] !=SEPARADOR){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArreglo (int [] arr, int MAX){
        for (int pos=0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
    
}
