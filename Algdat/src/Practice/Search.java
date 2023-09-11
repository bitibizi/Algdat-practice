package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Search {


    public static int[] line(int[] a, int fra, int til) {
        int antall = 0;

        for (int value : a) {
            if ((value >= fra) && (value <= til)) {
                antall++;
            }
        }

        int[] list = new int[antall];

        int k = 0;
        while (k < list.length) {
            for (int i : a) {
                if ((i >= fra) && (i <= til)) {
                    list[k] = i;
                    k++;
                }
            }

        }


        return list;
    }

    public static int lineærsøk(int[] a, int k, int verdi)
    {
        if (k < 1)
            throw new IllegalArgumentException("Må ha k > 0!");

        int j = k - 1;
        for (; j < a.length && verdi > a[j]; j += k);

        int i = j - k + 1;  // søker i a[j-k+1:j]
        for (; i < a.length && verdi > a[i]; i++);

        if (i < a.length && a[i] == verdi) return i;  // funnet
        else return -(i + 1);
    }





    public static void main(String[] args) {
        int[] a = {3, 8, 10, 12, 14, 16, 21, 24, 27, 30, 32, 33, 34, 37, 40};
        System.out.println(Arrays.toString(line(a, 10, 20)));
        System.out.println(lineærsøk(a,10,14));



    }

}
