public class EJEMPLODEBUG {
    final static int MAX=10;
    public static void main(String[] args) {
        int [] arr ={4,5,6,7,8,9,0,1,2,3};
        int i =0;
        while (i<MAX){
            if (arr[i]>5|| arr[i]%2!=0){
                correrIzquierda(arr, i);
                
            }
            i++;
        }
        mostrarArrelgo(arr);
    }
      public static void correrIzquierda (int arr[], int ini){
        for (int i=ini; i<MAX-1; i++){
            arr[i] = arr[i+1];
        }
    }
     public static void mostrarArrelgo (int [] arr){
        for (int pos = 0; pos<MAX; pos++){
            System.out.print("|" + arr[pos]);
        }
    }
}
