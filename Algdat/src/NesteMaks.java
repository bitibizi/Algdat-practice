import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.IntStream;

public class NesteMaks {

    public static int[] nestemaks(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new java.util.NoSuchElementException(" det går ikke");
        }

        int m = 0;
        int nm = 1;

        if (a[1] > a[0]) {
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];
        int nestemaks = a[nm];

        for (int i = 2; i < a.length; i++) {
            if (a[i] > nestemaks) {
                if (a[i] > maksverdi) {
                    nestemaks = maksverdi;
                    nm = m;

                    maksverdi = a[i];
                    m = i;
                } else {
                    nestemaks = a[i];
                    nm = i;
                }
            }
        }

        return new int[]{m, nm};

    }

    public static int[] nestemin(int[] a) {

        int l = a.length;

        if (l < 2) {
            throw new java.util.NoSuchElementException("det går ikke");
        }

        int min = 0;
        int nmin = 1;

        if (a[1] < a[0]) {
            min = a[1];
            nmin = a[0];
        }

        int minimum = a[min];
        int nesteminimum = a[nmin];

        for (int i = 2; i < l; ++i) {
            if (a[i] < nesteminimum) {
                if (a[i] < minimum) {
                    nmin = min;
                    nesteminimum = minimum;

                    min = i;
                    minimum = a[i];

                } else {
                    nmin = i;
                    nesteminimum = a[i];

                }
            }
        }

        return new int[]{min, nmin};
    }

    public static int[] nestMaks(int[] a)   // en turnering
    {
        int n = a.length;
        if (n < 2) {
            throw new java.util.NoSuchElementException("det går ikke");
        }

        int[] b = new int[2 * n];

        System.arraycopy(a, 0, b, n, n);

        for (int i = 2 * n - 2; i>1; --i) {
            b[i / 2] = Math.max(b[i], b[i + 1]);
        }

        System.out.println(Arrays.toString(b));

        int maksverdi = b[1];
        int nestemaks = Integer.MIN_VALUE;

        for (int m = 2 * n - 1, k = 2; k < m; k *= 2) {

            int tempverdi;

            if (maksverdi == b[k]) {
                tempverdi = b[k + 1];
            }
            else {
                tempverdi = b[k];
                k++;
            }
            if (tempverdi > nestemaks) {
                nestemaks = tempverdi;
            }


        }

        int index= IntStream.range(0,b.length).filter(i->maksverdi==b[i]).findFirst().orElse(-1);
        int finalNestemaks = nestemaks;
        int index1=IntStream.range(0,b.length).filter(i-> finalNestemaks ==b[i]).findFirst().orElse(-1);

        int []c={index, index1};

        System.out.println(Arrays.toString(c));



        return new int[] {maksverdi,nestemaks} ;




    } // nestMaks


    public static void main(String[] args) {
        int[] a = {10,2,7,5,1,4,9};


        System.out.println(Arrays.toString(nestMaks(a)));
    }
}
