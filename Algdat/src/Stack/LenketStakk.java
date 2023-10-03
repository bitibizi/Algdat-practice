package Stack;

import java.util.NoSuchElementException;

public class LenketStakk<T> implements Stakk<T> {

    @Override
    public void leggInn(T verdi) {

    }

    @Override
    public T kikk() {
        if (antall == 0) {
            throw new NoSuchElementException("Stakken er tom!");
        }
        return hode.verdi;
    }

    @Override
    public T taUt() {
        if (antall == 0) {
            throw new NoSuchElementException("Stakken er tom!");
        }

        T temp=hode.verdi;
        hode=hode.neste;
        antall--;
        return temp;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall==0;
    }

    @Override
    public void nullstill() {
        hode=null;
        antall=0;

    }

    private static final class Node<T>       // en «nøstet» nodeklasse
    {
        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste)   // nodekonstruktør
        {
            this.verdi = verdi;
            this.neste = neste;
        }

    } // class Node

    private Node<T> hode;             // stakkens topp
    private int antall;               // antall på stakken

    public LenketStakk()              // konstruktør
    {
        hode = null;
        antall = 0;
    }


}
