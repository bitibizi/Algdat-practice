package Generics;

import java.util.Arrays;

public class OddAndEvenPractice {

    @FunctionalInterface
    public interface Comparator<T>{
        int compare(T a, T b);
    }

    public static class SortereOddAndEven implements Comparator<Integer>{
        public int compare(Integer a, Integer b){

            if(a%2==b%2){
                return b.compareTo(a);
            } else if (a%2>b%2) {
                return 1;
            } else if (b%2>a%2) {
                return -1;
            }

            return 0;
        }
    }

    static <T> int maks(T [] value, int begin, int end, Comparator<T> comp){

        T maxverdi=value[begin];
        int maxverdiIndex=begin;
        for(int i=begin+1; i<end; i++){
            if(comp.compare(value[i], maxverdi)>0){
                maxverdi=value[i];
                maxverdiIndex=i;
            }
        }

        return maxverdiIndex;
    }

    static <T> void sort(T[] value, Comparator<T> comp){
        for(int i=0; i< value.length-1; i++){
            int maksIndex=maks(value, i, value.length, comp);

            T temp=value[i];
            value[i]=value[maksIndex];
            value[maksIndex]=temp;

        }
    }

    public static void main(String[] args) {
        Integer [] integers={9,8,7,6,5,4,3,2,1};
        SortereOddAndEven OddandEven=new SortereOddAndEven();
        sort(integers,OddandEven);
        System.out.println(Arrays.toString(integers));

    }
}
