package Recursion;

public class BinarySearch {
    public static void main(String[] args) {

        int[] a = {1, 2, 4, 8, 17, 19, 22};
        System.out.println(Search(3, a, 0, a.length - 1));
    }

    static int Search(int search_value, int[] value, int left, int right) {
        int middle = (left + right) / 2;

        if (left - right == 0) {
            if (value[middle] == search_value) {
                return middle;
            }
                return -left;

        }

        if (value[middle] <= search_value) {
            if (value[middle] == search_value) {
                return middle;
            }

            return Search(search_value, value, middle + 1, right);
        } else {
            return Search(search_value, value, left, middle - 1);
        }
    }

}

