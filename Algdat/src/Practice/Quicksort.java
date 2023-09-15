package Practice;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    public static int[] quicksort(int[] array) {
       return quicksort(array, 0, array.length - 1);
    }

    private static int[] quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return array;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = Partition(array, lowIndex, highIndex, pivot);
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);


        return array;

    }

    private static int Partition(int[] array, int lowIndex, int highIndex, int pivot) {

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);
        return leftPointer;
    }


    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    public static void main(String[] args) {

        int[] a = {30, 10, 14, 2, 10, 62, 31, 11, 7, 1, 2, 8};

        System.out.println(Arrays.toString(quicksort(a)));


    }
}
