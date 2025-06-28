public class parcial2025_2 {
    public static final int MAX=5;
    public static void main(String[] args) {
        //final int MAX=5;
        char[] texto= {'C', 'h', 'a', 'u', '!'};
        int [] numero = {1,4,2,0,3};

        int i= 0;
        while (i<MAX){
            if (i%2==0){
                texto[i]=texto[numero[i]];
                
            }else{
                texto[numero[i]]=texto[i];
            }
            i++;
        }
        mostrarArreglo(texto);

    }
    public static void mostrarArreglo (char [] arr){
        for (int pos=0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }

    }
    
}
