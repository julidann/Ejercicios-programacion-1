/*Ejercicio tipo parcial
Cuando se debe procesar texto expresado en lenguaje natural, una de las primeras tareas que se realiza es la
de eliminación de stopwords. Las stopwords son palabras muy comunes en un determinado lenguaje, por
ejemplo, artículos (el, la, las, los…), preposiciones (a, ante, con, por…), etc.
Dado un texto almacenado en un arreglo de caracteres de tamaño MAX_A, donde cada palabra está
delimitada por espacios, comas (,) o puntos (.) se pide eliminar todas las stopwords almacenadas en otro
arreglo de caracteres de tamaño MAX_S que se encuentra delimitado por espacios.
Por ejemplo, dado un texto almacenado en un arreglo A:
l a c a s a r o j a , a l a v u e l t a d e l a e s q u i n a .
Y una lista de stopwords S
a l o l o s d e l a l a s
El arreglo A debería quedar de la siguiente forma luego de la eliminación de stopwords:
c a s a r o j a , v u e l t a e s q u i n a . */
public class parcial_2 {
    public static final int MAX_A= 41, MAX_S=20;

    public static void main(String[] args) {

        char [] arrA= {' ', 'l', 'a', ' ', 'c', 'a', 's', 'a', ' ', 'r', 'o', 'j', 'a', ',', ' ', 'a', ' ', 'l', 'a', ' ', 'v', 'u', 'e', 'l', 't', 'a', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'e', 's', 'q', 'u', 'i', 'n', 'a','.'}; 
        char [] arrS ={' ','a', ' ', 'l', 'o', ' ', 'l', 'o', 's', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'l', 'a', 's', ' '};
        System.out.println("Arreglo original");
        mostrarArrelgo(arrA);

        eliminarStopwords (arrA, arrS);
        System.out.println("Arreglo sin stopwords");
        mostrarArrelgo(arrA);
        
    }
    public static void eliminarStopwords (char [] arrA, char []arrS){
        int iniA=0;
        int finA=-1;
        

        while (iniA<MAX_A){
            iniA=buscarInicio (arrA, finA+1, MAX_A);
            if (iniA<MAX_A){
                finA=buscarFin (arrA, iniA, MAX_A);
                int iniS=0;
                int finS=-1;
                boolean encontrada=false;

                while (iniS<MAX_S && !encontrada){
                    iniS=buscarInicio (arrS, finS+1, MAX_S);
                    if (iniS<MAX_S){
                    finS=buscarFin (arrS, iniS, MAX_S);
                    
                    if (contieneStopwords(arrA, iniA,finA, arrS, iniS, finS)){
                        eliminarStopwords(arrA, iniA, finA);
                        encontrada=true;
                        finA = iniA - 1;
                    }
                }
            }
        }
    }
    
}
public static boolean esSeparador (char arrA){
    if (esLetra(arrA)){
        return false;
    }
    else{
        return true;
    }
}
public static boolean esLetra (char letra){
    return (('a'<=letra && 'z'>=letra) || ('A'<=letra && 'Z'>=letra));
}

public static void eliminarStopwords (char [] arrA, int iniA, int finA){
    while (iniA<=finA){
        correrIzquierda(arrA, finA);
        finA--;
    }
    arrA[MAX_A-1]= ' ';
}
public static boolean contieneStopwords (char [] arrA, int iniA, int finA, char[] arrS, int iniS, int finS){
    int tamanioA=finA-iniA+1;
    int tamanioS=finS-iniS+1;
    boolean sonIguales= false;
    if (tamanioA==tamanioS){
        while (iniA<=finA && !sonIguales){
            sonIguales= arrA[iniA]==arrS [iniS];
            iniA++;
            iniS++;
        }
    }
    return sonIguales;
    
}
public static void correrIzquierda (char [] arr, int pos){
    for (int i= pos; i<MAX_A-1 ; i++){
        arr[i]=arr[i+1];
    }

}
 public static int buscarInicio(char [] arr, int pos, int MAX){
        while (pos<MAX && esSeparador(arr[pos])){
            pos++;
        }
        return pos;
    }
    public static int buscarFin (char [] arr, int pos, int MAX){
        while (pos<MAX && !esSeparador(arr[pos])){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArrelgo (char [] arr){
        for (int pos = 0; pos<MAX_A; pos++){
            System.out.print("| " + arr[pos]);
        }
    }
}
