package Practice;

import java.util.Arrays;

public class Generics {

    public static void main(String[] args) {
        Integer[] a = {1, 8, 9, 18, 98, 2, 3, 9};
        Character[] b = {'A', 'C', 'K', 'Z', 'L', 'Y', 'M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};


        Person[]d={new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Niles", "Abrahamsen")};
        System.out.println(maks_generic(d));

        System.out.println("Maks av int-array:");
        System.out.println(maks(a));

        System.out.println("Maks av char-array:");
        System.out.println(maks(b));

        System.out.println("Generic maks av int-array:");
        System.out.println(maks_generic(a));

        System.out.println("Generic maks av char-array:");
        System.out.println(maks_generic(b));

        System.out.println("Generic maks av string-array:");
        System.out.println(maks_generic(c));

    }

    public static class Person implements Comparable<Person>{
        String firstname;
        String lastname;
        Person(String firstname, String lastname){
            this.firstname=firstname;
            this.lastname=lastname;
        }

        public int compareTo(Person other){
            int lastCompare=this.lastname.compareTo(other.lastname);
            if(lastCompare==0){
                return this.firstname.compareTo(other.firstname);
            }else{
                return lastCompare;
            }
        }
    }

    static
    <T extends Comparable<? super T>>
    int maks_generic(T[] values) {
        T current_max = values[0];
        int current_index = 0;

        for (int i=1; i<values.length; ++i) {
            //if (values[i] > current_max) {
            if (values[i].compareTo(current_max) > 0) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }


    static int maks(Integer[] values) {
        int current_max = values[0];
        int current_index = 0;

        for (int i=1; i<values.length; ++i) {
            if (values[i] > current_max) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    static int maks(Character[] values) {
        char current_max = values[0];
        int current_index = 0;

        for (int i=1; i<values.length; ++i) {
            if (values[i] > current_max) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }
}
