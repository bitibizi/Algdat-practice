package Recursion.Oppgave;

import java.util.Arrays;

import static Merge.Oppgave1.flett;
import static Practice.Kap12Tabell.bytt;


public class Oppgave1 {

    public static int sum(int n) {

        if (n == 1) {
            return 1;
        }
        return (n * n) + sum(n - 1);
    }

    public static int fakultet(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fakultet(n - 1);
    }

    public static long fib1(int n)         // det n-te Fibonacci-tallet
    {
        long k = 0;
        long i = 1;
        long j = 0;
        int antall = 1;
        while (antall < n) {
            j = k + i;
            k = i;
            i = j;
            antall++;

        }

        return j;
    }

    public static long fib_recursive(int n) {
        if (n <= 1)
            return n;
        return fib_recursive(n - 1) + fib_recursive(n - 2);
    }

    public static int bi(int n, int k) {
        if (k > n || k < 0) {
            return 0;
        }
        return bi(n - 1, k - 1) + bi(n - 1, k);

    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a, v++, h--);                 // bytter om a[v] og a[h]
            else return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static int[] kvikksortering0(int[] a, int v, int h) {

        if (v >= h) return a;

        int k = sParter0(a, v, h, (v + h) / 2);   // se Programkode 1.3.9 f)
        kvikksortering0(a, v, k - 1);
        kvikksortering0(a, k + 1, h);


        return a;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 5, 1, 3, 7, 8, 10, 9, 6};
        /*System.out.println(Arrays.toString(flettesortering(a)));
        towerOfHanoi('A', 'B', 'C', 5);*/
        int n = 12;
        System.out.println(fib_recursive(n));
        System.out.println(fib_recursion(n, 1, 1));


    }

    private static void flettesortering(int[] a, int[] b, int fra, int til) {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element

        int m = (fra + til) / 2;        // midt mellom fra og til

        flettesortering(a, b, fra, m);   // sorterer a[fra:m>
        flettesortering(a, b, m, til);   // sorterer a[m:til>

        // fletter a[fra:m> og a[m:til>
        flett(a, b, fra, m, til);         // Programkode 1.3.11 f)
    }

    public static int[] flettesortering(int[] a) {
        int[] b = new int[a.length / 2];    // en hjelpetabell for flettingen
        flettesortering(a, b, 0, a.length);  // kaller metoden over
        return a;
    }

    public static void towerOfHanoi(char a, char b, char c, int brikkenr) {
        if (brikkenr == 0) {
            return;
        }


        //Flytt alle unntatt nederste fra A til B (hjelpepinnen)
        towerOfHanoi(a, c, b, brikkenr - 1);

        //Flytt nederste fra A til C
        System.out.println("Flytter brikke " + brikkenr + " fra " + a + " til " + c);

        //Flytt alle fra B til C
        towerOfHanoi(b, a, c, brikkenr - 1);
    }

    public static long fib_recursion(int n, int a, int b) {
        if (n <= 2) {
            return 1;
        }

        if (n == 3) {
            return a + b;
        }
        return fib_recursion(n - 1, b, a + b);

    }


}