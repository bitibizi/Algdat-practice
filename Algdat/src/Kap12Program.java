import java.util.Arrays;

public class Kap12Program {

    public static void main(String ... args)      // hovedprogram
    {
        int[] a = Kap12Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Kap12Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        int [] list={3,4,6,9,7};

        int []b=Kap12Tabell.nestMaks(list);

        System.out.println(Arrays.toString(b));






    } // main
}
