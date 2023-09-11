package Practice;

import java.util.Arrays;

public class Oppgave4 {

    public static int[] separateEvenOddNumbers(int arr[])
    {
        int left=0;
        int right=arr.length-1;
        for (int i = 0; i < arr.length; i++) {

            while(arr[left]%2==0)
            {
                left++;
            }
            while(arr[right]%2==1)
            {
                right--;
            }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        return arr;
    }


    public static void main(String [] args){

        int [] list ={20,40,60,10,1,4,6,2,1,7,8};

        System.out.println(Arrays.toString(separateEvenOddNumbers(list)));
    }

}
