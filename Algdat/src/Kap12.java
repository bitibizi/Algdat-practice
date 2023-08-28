import java.util.Arrays;

public class Kap12 {

    public static int min(int[] a, int from, int to){
        if(from<0|| to>a.length || from>=to){
            throw new IllegalArgumentException("Illegal intervall");
        }

        int m=from;
        int minimum=a[from];

        for(int i= from+1; i<to; i++){
            if(a[i]<minimum){
                minimum=a[i];
                m=i;
            }
        }
        return m;
    }

    public static int min(int[]a){
        return min(a, 0, a.length);
    }

    public static int[] copyofarrange(int[] a, int c, int b){

        return Arrays.copyOfRange(a,c,b);


    }



    public static int maks(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int minverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0;          // legger tallet 2147483647 sist

        for (int i = 1; ; i++)         // i starter med 0
            if (a[i] <=minverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp<=minverdi ? sist:m; //if sentence

                }
                else
                {
                minverdi = a[i];        // maksverdi oppdateres
                m = i;                   // m oppdateres
            }
            }
    } // maks




    public static void main(String [] args){

        int [] list={2,4,1};
        int [] list1={1,2,3,4,5,6,7,8,9};
        System.out.println(maks(list));

        System.out.println(Arrays.toString(copyofarrange(list1, 2, 6)));
    }
}
