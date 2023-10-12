package Heap;

import java.util.Arrays;

public class HeapSortering {

    public static void main(String[] args) {
        int values[] = {-99, 5, 9, 8, 3, 1};
        heapsort(values);

    }

    static void heapsort(int[] values) {
        System.out.print("Array før" + Arrays.toString(values));
        System.out.println();
        heapify(values);
        System.out.print("Array etter" + Arrays.toString(values));

        for (int i = 1; i < values.length; ++i) {
            int first = 1;
            int last = values.length - i;

            int tmp = values[first];
            values[first] = values[last];
            values[last] = tmp;

            int current = first;
            int left_child = current * 2;
            int right_child = (current * 2) + 1;
            while (true) {
                if (left_child < last &&
                        values[left_child] < values[right_child]
                        && values[left_child] < values[current]) {
                    int tmp2=values[left_child];
                    values[left_child]=values[current];
                    values[current]=tmp2;
                    current=left_child;
                }else if(right_child<last&& values[right_child]<values[left_child]&&
                        values[right_child]<values[current]){
                    int tmp2=values[right_child];
                    values[right_child]=values[current];
                    values[current]=tmp2;
                    current=right_child;
                }else{
                    break;
                }

                left_child=current*2;
                right_child=current*2;


            }
        }
        System.out.println("Array etter uttak: " + Arrays.toString(values));

    }

    static void heapify(int[] values) {
        for (int i = 1; i < values.length; i++) {

            int current = i;
            int parent = i / 2;
            while (parent > 0 && values[parent] > values[current]) {
                System.out.println("Bytter " + current + " med " + parent);
                int tmp = values[parent];
                values[parent] = values[current];
                values[current] = tmp;
                current = parent;
                parent = current / 2;

            }
        }
    }
}
