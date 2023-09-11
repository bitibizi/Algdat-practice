package Practice;

public class Oppgave5 {

    public static void rotasjon2(char[] a) {
        int end = a.length - 1;
        int n = a.length;

        char oldTemp;
        char newTemp = a[0];

        for (int i = 0; i <= end; i++) {
            oldTemp = a[(i+1) % n];
            a[(i+1) % n] = newTemp;
            newTemp = oldTemp;
        }



    }

    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        rotasjon2(a);
        System.out.println();
    }
}
