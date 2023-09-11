package Practice;

import java.util.Arrays;

public class QuicksortPractice {

    public static int antallOmbyttinger(int []a, int pivot){
        int antall=0;
        int m=pivot-1;
        for(int i=0; i<m; i++){
            if(a[i]>m){
                antall++;
            }
        }
        return antall;
    }

    public static void swap(int[] a, int b, int c){
        int temp=a[c];
        a[c]=a[b];
        a[b]=temp;
    }

    private static int [] quicksort(int []a, int lowIndex, int highIndex){

        if(lowIndex>=highIndex){
            return a;
        }


        swap(a,lowIndex, highIndex);

        int pivot=a[highIndex];


        int leftpointer=lowIndex;
        int rightpointer=highIndex;


        while(leftpointer<rightpointer){

            while(a[leftpointer]<=pivot&& leftpointer<rightpointer){
                leftpointer++;
            }

            while(a[rightpointer]>=pivot && leftpointer<rightpointer){
                rightpointer--;
            }

            swap(a, leftpointer,rightpointer);
        }

        swap(a, leftpointer, highIndex);

        quicksort(a, lowIndex, leftpointer-1);
        quicksort(a, leftpointer+1, highIndex);


        return a;
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v >= h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h)
            {
                swap(a,v++,h--);          // bytter om a[v] og a[h]
                System.out.println(Arrays.toString(a) + " v = " + v + " h = " + h);
            }
            else  return v;                             // partisjoneringen er ferdig
        }
    }

    public static void main(String[] args) {
        int[] a = {7,10,3,4,1,6,8,2,9,5};
        System.out.println(parter0(a,0,a.length-1,7));





    }
}
