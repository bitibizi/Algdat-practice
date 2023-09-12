package Generics;

import Practice.Generics;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        Integer[] a = {1, 8, 9, 18, 98, 2, 3, 9};
        Character[] b = {'A', 'C', 'K', 'Z', 'L', 'Y', 'M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};


        Person[] d = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Niles", "Abrahamsen"), new Person("Tor", "Tonsen")};


        int personIndex=maks(d,0,d.length);

        System.out.println("største person "+ d[personIndex]);
        System.out.println("Sorterer personer");
        System.out.println("før sortering"+ Arrays.toString(d));
        sort(d);
        System.out.println("Etter sortering"+ Arrays.toString(d));


    }

    static
    <T extends Comparable<? super T>>
    void sort(T[] values){
        for(int i=0; i<values.length-1; i++){
            int maxIndex=maks(values, i, values.length);

            T temp=values[i];
            values[i]=values[maxIndex];
            values[maxIndex]=temp;

        }
    }

    static <T extends Comparable<? super T>>
    int maks(T[] values, int begin, int end) {
        T current_max = values[begin];
        int current_index = begin;

        for (int i = begin+1; i < end; ++i) {
            //if (values[i] > current_max) {
            if (values[i].compareTo(current_max) > 0) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    public static class Person implements Comparable<Person> {
        String firstname;
        String lastname;

        Person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public int compareTo(Person other) {
            int lastCompare = this.lastname.compareTo(other.lastname);
            if (lastCompare == 0) {
                return this.firstname.compareTo(other.firstname);
            } else {
                return lastCompare;
            }
        }
public String toString(){
            return firstname+" "+lastname;
}

    }


}
