import java.util.Arrays;

public class Main {

    public static int min(int[] a){
        int m=a.length-1;
        for(int i=a.length-1;i>=0;i--){
            if(a[i]>a[m]){
                m=i;
            }

        }

        return m;

    }

    public static int[] minmaks(int []a){
        int m1=0;
        int m2=0;
        for(int i=1; i<a.length; i++){
            if(a[i]<a[m1]){
                m1=i;
            }
        }

        for(int j=1; j<a.length;j++){
            if(a[j]>a[m2]){
                m2=j;
            }
        }

        int []b= {m1,m2};
        return b;

    }

    public static long fak(int n){
        int i;
        int fact=1;

        for(i=2;i<=n;i++){
            fact*=i;
        }

        return fact;

    }

    public static long fak1(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n < 0");
        long fak = 1;

        for (int i = 2; i <= n; i++) fak *= i;

        return fak;
    }

    public static int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks





    public static void main(String[] args) {

       int []list={8,4,17,10,6,20,1,11,15,18,9,2,19};
        System.out.println(min(list));


       int [] b={};
      // System.out.println(maks1(b));
        System.out.println(fak1(5));
        System.out.println(fak(5));

    }

}