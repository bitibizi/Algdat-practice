package Search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Search {
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length - 1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0;
        for (; a[i] < verdi; i++) ;  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i+1);   // sjekker innholdet i a[i]
    }

    public static int linearmethod(int [] a, int fra, int til, int verdi){

        if (a.length == 0 || verdi > a[a.length - 1])
            return -(a.length + 1);


        int i=fra;

        while (a[i] < verdi &&i <til){
            i++;
        }
        return verdi == a[i] ? i : -(i+1 );




    }

    public static int linearSearch(int [] a, int k, int verdi){

        if (a.length == 0 || verdi > a[a.length - 1])
            return -(a.length + 1);

        int i = k-1;
        while( i<a.length&& a[i] <verdi ){
            i+=k;
        }
        int j=i-k+1;
        while( j <a.length && a[j]<verdi ){
            j++;
        }

        return i<a.length && verdi == a[i] ? i : -(j+1);

    }

    public static int[] lineærIntervallsøk (int[] a, int fraverdi, int tilverdi){
        int min=0;
        for(int i=0; i<a.length; i++){
            if(a[i]==fraverdi){
                min=i;
            }
        }
        int max=0;
        for(int j=0; j<a.length; j++){
            if(a[j]==tilverdi){
                max=j;
            }
        }

     return Arrays.copyOfRange(a,min, max+1);
    }

    public static void main(String[] args) {
        int[] a = {0,2,4,6,8,10,12,14};
        int b = 35;
        int [] c= IntStream.range(1,100).toArray();
        int [] d=new int[100];
        int[] array = new int[12];
        Arrays.setAll(array, i -> i*2);
        System.out.println(lineærsøk(array, b));
        System.out.println(linearmethod(array,0,array.length-1, b));
        System.out.println(linearSearch(array,10, b));
        System.out.println(Arrays.toString(lineærIntervallsøk(a, 6, 10)));

    }

}
