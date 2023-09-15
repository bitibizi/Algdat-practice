package Recursion;

import java.util.Arrays;



public class RecursivePermutasjon {
    public static void main(String[] args) {
        int a[] ={1,2,3};
        recursive(a,0);
    }

    public static void swap(int [] a, int b, int c){

        int temp=a[b];
        a[b]=a[c];
        a[c]=temp;
    }
    public static void recursive(int [] a, int k){
        if(k==a.length-1){
            System.out.println(Arrays.toString(a));

        }

        for(int i=k; i<a.length; i++){
            swap(a,i,k);
            recursive(a,k+1);
            swap(a, k,i);
        }
    }
}
