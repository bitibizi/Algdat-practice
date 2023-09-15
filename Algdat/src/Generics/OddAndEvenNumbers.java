package Generics;

import java.util.Arrays;
import java.util.Comparator;

public class OddAndEvenNumbers {

    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T a, T b);
    }
// sammenligner alle oddetall først og sammenlignin i bare partall etterpå
    public static class OddePartallKomparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a % 2 == b % 2) return a.compareTo(b);
            else if (a % 2 > b % 2) {
                return 1;
                //a er nye tall og b er maksverdi og dersom a er even tall og b er eventall ønsker at oddtall blir maksverdi
                // og derfor retunerer 1
            } else if (b % 2 > a % 2) {
                return -1;
                // Dersom maksverdi b er oddtall og a er even tall vil gjerne beholde oddtall som maksverdi derfor
                //retunerer -1 for å gå videre
            }

            return 0;
        }
    }

    //maksverdi er ikke egentlig maks verdi
    static <T> int maks(T[] values, int begin, int end, Comparator<T> comp) {
        T currentMax = values[begin];
        int currentIndex = begin;

        for (int i = begin+1; i < end; i++) {
            if (comp.compare(values[i], currentMax) >0) {
                currentMax = values[i];
                currentIndex = i;
            }
        }

        return currentIndex;
    }

    static <T> void sort(T[] values, Comparator<T> comp) {
        for (int i = 0; i < values.length - 1; i++) {
            int maxIndex = maks(values, i, values.length, comp);

            T temp = values[i];
            values[i] = values[maxIndex];
            values[maxIndex] = temp;
        }
    }


    public static void main(String[] args) {

        Integer[] integers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println("Før Sortering");
        System.out.println(Arrays.toString(integers));

        OddePartallKomparator tall = new OddePartallKomparator();
        sort(integers, tall);
        System.out.println("Etter Sortering");
        System.out.println(Arrays.toString(integers));
    }
}
