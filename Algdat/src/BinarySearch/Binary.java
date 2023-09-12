package BinarySearch;

public class Binary {
    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static int binærsøk(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);
        int v = fra, h = til - 1;

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h) / 2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk2(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);
        int v = fra, h = til - 1;

        while (v <= h) {
            int m = (v + h) / 2;
            int midtverdi = a[m];

            if (verdi > midtverdi) v = m + 1;
            else if (verdi < midtverdi) h = m - 1;
            else return m;
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk3(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);  // se Programkode 1.2.3 a)
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

    public static int binary(int []a, int verdi){
        int v=0, h=a.length-1;

        while(v<h){
            int m= (v+h+1)/2;
            if(verdi<a[m]){
                h=m-1;
            }else{
                v=m;
            }
        }
        if(h<v||verdi<a[v]){
            return -(v+1);
        }else if(verdi==a[v]){
            return v;
        }
        return -(v+2);

    }



    public static void main(String[] args) {
        int[] a = {2, 5, 6, 9, 10, 12, 15, 17, 19, 19, 19, 19, 22, 23, 25};
        int[] b = {1, 3, 4, 4, 5, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};
        int c = 4;
        System.out.println(binærsøk(b, 0, a.length, c));
        System.out.println(binærsøk2(b, 0, a.length, c));
        System.out.println(binærsøk3(b, 0, a.length, c));
        System.out.println(binary(b, 0));
    }

}
