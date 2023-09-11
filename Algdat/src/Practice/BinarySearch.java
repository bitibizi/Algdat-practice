package Practice;

public class BinarySearch {
    public static int binærsøk(int[] a, int fra, int til, int verdi) {

        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h) / 2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) {
                return m;
            }          // funnet
            else if (verdi > midtverdi) {
                v = m + 1;
            }     // verdi i a[m+1:h]
            else {
                h = m - 1;
            }                          // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int bin123(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk(a, 0, 10, verdi);  // bruker metoden over
    }

    public static int bin(int[] a, int fra, int til, int verdi) {

        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h) / 2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else return -(v + 2);                       // ikke funnet
    }


    public static void main(String[] args) {
        int[] a = {2, 5, 6, 9, 10, 12, 15, 17, 19, 19, 19, 19, 22, 23, 25};

        System.out.println(bin123(a, 26));


    }
}
