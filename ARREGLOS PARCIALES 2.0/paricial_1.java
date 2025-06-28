/*EJERCICIO PARCIAL 1
Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las
secuencias están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha
comportado su animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad
N de repeticiones. Un patrón que se repite una cierta cantidad de veces consecutivas significa que el animal
puede estar pastoreando, caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado
con -1 (de tamaño igual al arreglo que tiene los datos), hacer un programa en JAVA que:
- Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
siguen repitiendo consecutivamente luego de la cantidad N.
Por ejemplo, si tenemos el siguiente arreglo de datos:
-1 12 22 44 -1 23 34 55 -1 23 34 55 -1 23 34 55 -1 23 34 57 -1
El arreglo patrón X Y Z a analizar es X=23, Y=34, Z=55 y el N=2
-1 -1 -1 -1 -1 -1 -1 -1 23 34 55 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
El arreglo resultante sería
-1 12 22 44 -1 23 34 55 -1 23 34 55 -1 -1 23 34 57 -1 -1 -1 -1 */

public class paricial_1 {
    public static final int MAX=21, SEPARADOR=-1;
    public static void main(String[] args) {
        int [] arrDatos ={-1, 12, 22, 44, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 57, -1};
        int [] arrPatron = {-1, -1, -1, -1, -1, -1, -1, -1, 23, 34, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println("Arreglos originales");
        mostrarArreglo (arrDatos);
        System.err.println(" ");
        mostrarArreglo (arrPatron);

        procesarInfo(arrDatos,arrPatron);
        System.out.println("Arreglo corregido");
        mostrarArreglo(arrDatos);

    }
    public static void procesarInfo(int[] arrD, int[] arrP){
        int iniD=0;
        int finD=-1;
        int N=2;
        int secuenciaRepetida=0;

        while (iniD<MAX){
            iniD=buscarInicio(arrD, finD+1);
            if (iniD<MAX){
                finD=buscarFin(arrD, iniD);

                int iniP=0;
                int finP=-1;

                while (iniP<MAX){
                    iniP=buscarInicio (arrP, finP+1);
                    if (iniP<MAX){
                        finP=buscarFin (arrP, iniP);

                        if (compartenValor(arrD, iniD, finD,arrP,iniP)){
                            secuenciaRepetida++;
                                if (secuenciaRepetida > N) {
                                eliminarSecuencia(arrD, iniD, finD);
                               // finD = iniD - 1;
                                }
                                } else {
                                secuenciaRepetida = 0;
                    }
                    }
                }
            }
            }
    }
    public static boolean compartenValor(int [] arrD, int iniD, int finD, int[] arrP, int iniP){
        boolean sonIguales= true;
        while (iniD<=finD && sonIguales){
            sonIguales= arrD[iniD]== arrP[iniP];
            iniD++;
            iniP++;
        }
        return sonIguales;
    }
    public static void eliminarSecuencia (int [] arrD, int iniD, int finD){
        while (iniD<=finD){
            correrIzquierda(arrD, iniD);
            finD--;
        }
    }
    public static void correrIzquierda (int arrD[], int pos){
        for (int i=pos; i<MAX-1; i++){
            arrD[i]= arrD[i+1];
        }
    }

    public static int buscarInicio (int [] arr, int pos){
        while (pos<MAX && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (int [] arr, int pos){
        while (pos<MAX && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos -1;
    }
    public static void mostrarArreglo (int [] arr){
        for (int pos=0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
}
