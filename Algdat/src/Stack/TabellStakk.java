package Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class TabellStakk<T> implements Stakk<T> {
    private T[] a;                     // en T-tabell
    private int antall;                // antall verdier på stakken

    public TabellStakk()               // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde)     // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[]) new Object[lengde];     // oppretter tabellen
        antall = 0;                      // stakken er tom
    }

    @Override
    public void leggInn(T verdi) {
        if (antall == a.length) {
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2 * antall);  // dobler

            a[antall++] = verdi;
        }

    }

    @Override
    public T kikk() {
        if (antall == 0) throw
                new NoSuchElementException("Stakken er tom!");

        return a[antall - 1];
    }

    @Override
    public T taUt() {
        if (antall == 0) throw new NoSuchElementException("stakken er tom!");

        antall--;

        T temp=a[antall];
        a[antall]=null;
        return temp;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {
        for (int i = 0; i < antall; i++) a[i] = null;
        antall = 0;

    }

    public String toString2()  // bruker StringBuilder
    {
        if (tom()) return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[');
        s.append(a[antall-1]);

        for (int i = antall - 2; i >= 0; i--)
            s.append(',').append(' ').append(a[i]);

        s.append(']');
        return s.toString();
    }

    public static <T> void snu(Stakk<T> A){

        Stakk<T> B= new TabellStakk<T>();
        Stakk<T> C =new TabellStakk<T>();

        while (!A.tom()) B.leggInn(A.taUt());  // verdiene flyttes fra A til B
        while (!B.tom()) C.leggInn(B.taUt());  // verdiene flyttes fra B til C
        while (!C.tom()) A.leggInn(C.taUt());  // verdiene flyttes fra C til A

    }

    public static <T> void kopier(Stakk<T> A, Stakk<T> B){
        Stakk<T> C = new TabellStakk<T>();
        while (!A.tom()) C.leggInn(A.taUt());
        while (!C.tom())
        {
            T t = C.taUt();
            B.leggInn(t);
            A.leggInn(t);
        }


    }



}  // class TabellStakk
