package QuickSort;

import Practice.Quicksort;

import java.util.Arrays;

import static Practice.Kap12Tabell.randPerm;

public class QuickSort {
    static void bytt(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    private static int[] Quicksort(int[] a, int v, int h) {

        if(v>=h){
            return a;
        }

        int leftIndex = v;
        int rightIndex = h;
        int pivot = a[h];


        while (leftIndex < rightIndex) {

            while (leftIndex <= rightIndex && a[leftIndex] < pivot) {
                leftIndex++;
            }

            while (leftIndex <= rightIndex && a[rightIndex] > pivot) {
                rightIndex--;
            }
            bytt(a, leftIndex, rightIndex);

        }

        bytt(a, leftIndex, h);

        Quicksort(a, v, leftIndex-1 );
        Quicksort(a,leftIndex+1, h);


        return a;
    }



    public static void main(String[] args) {

        int[] b = randPerm(30);
        System.out.println(Arrays.toString(Quicksort(b, 0, b.length)));

    }

}
