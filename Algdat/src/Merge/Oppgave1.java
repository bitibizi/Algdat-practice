package Merge;

import java.util.Arrays;

import static Practice.Kap12Tabell.randPerm;

public class Oppgave1 {
    public static int[] enkelFletting(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];  // en tabell av rett størrelse
        int k = Math.min(a.length, b.length);    // lengden på den korteste

        for (int i = 0; i < k; i++) {
            c[2 * i] = a[i];        // først en verdi fra a
            c[2 * i + 1] = b[i];    // så en verdi fra b
        }
        // vi må ta med resten
        System.arraycopy(a, k, c, 2 * k, a.length - k);
        System.arraycopy(b, k, c, 2 * k, b.length - k);

        return c;

    }

    public static String enkelfletting(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        char[] c = new char[A.length + B.length];
        int k = Math.min(A.length, B.length);

        for (int i = 0; i < k; i++) {
            c[2 * i] = A[i];
            c[(2 * i) + 1] = B[i];
        }

        System.arraycopy(A, k, c, 2 * k, A.length - k);
        System.arraycopy(B, k, c, 2 * k, B.length - k);

        return Arrays.toString(c);
    }

    public static String enkelFletting(String a, String b) {
        int k = Math.min(a.length(), b.length());  // lengden på den korteste
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < k; i++) {
            s.append(a.charAt(i)).append(b.charAt(i));
        }

        s.append(a.substring(k)).append(b.substring(k));

        return s.toString();
    }

    public static int[] Integers(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            c[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (i < b.length) {
            c[k++] = b[i++];
        }

        return c;
    }

    public static void flett(int[] a, int[] b, int fra, int m, int til) {
        int n = m - fra;                // antall elementer i a[fra:m>
        System.arraycopy(a, fra, b, 0, n);  // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;      // løkkevariabler og indekser

        while (i < n && j < til)        // fletter b[0:n> og a[m:til> og
        {                               // legger resultatet i a[fra:til>
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    private static void flettesortering(int[] a, int[] b, int fra, int til) {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element
        int m = (fra + til) / 2;        // midt mellom fra og til

        flettesortering(a, b, fra, m);   // sorterer a[fra:m>
        flettesortering(a, b, m, til);   // sorterer a[m:til>

        if (a[m - 1] > a[m]) flett(a, b, fra, m, til);  // fletter a[fra:m> og a[m:til>
    }

    public static void flettesortering(int[] a) {
        int[] b = Arrays.copyOf(a, a.length / 2);   // en hjelpetabell for flettingen
        flettesortering(a, b, 0, a.length);          // kaller metoden over
    }

    public static int forskjellige2(int[] a) {
        if (a.length <= 1) return a.length;

        int[] b = new int[a.length - 1];  // hjelpetabell

        int i = 1, k = 1, j = 0;
        while (i < a.length) {
            if (a[i] != a[i - 1]) {

                a[k] = a[i];
                k++;
                i++;
            } else {
                b[j] = a[i];
                j++;
                i++;
            }

        }
        System.arraycopy(b, 0, a, k, j);
        for(int l:a){
            System.out.println(l+",");
        }
        return k;
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 3, 5, 5, 7, 7, 9, 11}, b = {2, 4, 6, 8, 10};
        int[] f = randPerm(10_000_000);
        int[] g = f.clone();


        String c = "James", d = "Pettersen";

       /* System.out.println(enkelfletting(c, d));
        System.out.println(enkelFletting(c, d));

        long tid1 = System.currentTimeMillis();
        flettesortering(f);
        tid1 = System.currentTimeMillis() - tid1;

        long tid2 = System.currentTimeMillis();
        Practice.Quicksort.quicksort(b);
        tid2 = System.currentTimeMillis() - tid2;

        System.out.println("Flettesortering: " + tid1);
        System.out.println("Kvikksortering: " + tid2);*/

        System.out.println(forskjellige2(a));


    }

}
