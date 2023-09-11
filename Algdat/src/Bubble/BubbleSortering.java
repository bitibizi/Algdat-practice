package Bubble;

import static Practice.Kap12Tabell.bytt;

public class BubbleSortering {

    public static int boblesortering1(int[] a)     // hører til klassen Tabell
    {
        for (int n = a.length; n > 1; n--)           // n reduseres med 1 hver gang
        {
            for (int i = 1; i < n; i++)                // går fra 1 til n
            {
                if (a[i - 1] > a[i]) bytt(a, i - 1, i);  // sammenligner/bytter
            }
        }

        return 0;
    }

    public static int boblesortering2(int[] a)
    {
        for (int n = a.length; n > 1; )            // n er intervallgrense
        {
            int byttindeks = 0;                      // hjelpevariabel
            for (int i = 1; i < n; i++)              // går fra 1 til n
            {
                if (a[i - 1] > a[i])                   // sammenligner
                {
                    bytt(a, i - 1, i);                   // bytter
                    byttindeks = i;                      // høyre indeks i ombyttingen
                }
            }
            n = byttindeks;                          // ny intervallgrense
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] a={2,7,3,9,6,1,5,6};
        System.out.println(boblesortering2(a));

    }


}
