package Practice;

public class Forskyving {
    public static void bytt(char[] a, int i, int j)
    {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static char[] rotasjon(char[] a, int d)             // 2. versjon
    {
        int n = a.length;
        if (n < 2){
            return a;
        };                                     // tomt eller en verdi

        if ((d %= n) < 0) d += n;                              // motsatt vei?

        for (int v = 0, h = n - 1; v < h; Forskyving.bytt(a, v++, h--));  // snur a[a:n>
         // snur a[0:d>
        for (int v = d, h = n - 1; v < h; Forskyving.bytt(a, v++, h--));
        for (int v = 0, h = d - 1; v < h; Forskyving.bytt(a, v++, h--)); // snur a[d:n>

        return a;
    }



    public static void main(String[] args) {
        char[] c = "ABCDEFGHIJKLMNOP".toCharArray();

        System.out.println(rotasjon(c, 10));
    }


}
