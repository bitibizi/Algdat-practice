package Generics;

import java.util.Arrays;

public class VisitorPatterTest {

    @FunctionalInterface
    public interface Komparator<T> {
        int compare(T a, T b);
    }

    public static class DesendingPersonComparator implements Komparator<Person> {

        public int compare(Person a, Person b) {
            int lasCompare = a.lastname.compareTo(b.lastname);
            if (lasCompare == 0) {
                return a.firstname.compareTo(b.firstname);
            } else {
                return lasCompare;
            }

        }

    }
    public static class AscendingPersonComparator implements Komparator<Person> {

        public int compare(Person a, Person b) {
            int lasCompare = b.lastname.compareTo(a.lastname);
            if (lasCompare == 0) {
                return b.firstname.compareTo(a.firstname);
            } else {
                return lasCompare;
            }

        }

    }

    public static <T> int maks(T[] values, int begin, int end, Komparator<T> comp) {
        T current_max = values[begin];
        int current_index = begin;

        for (int i = begin + 1; i < end; ++i) {
            //if (values[i] > current_max) {
            if (comp.compare(values[i], (current_max)) > 0) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    public static <T> void sort(T[] values, Komparator<T> comp) {

        for (int i = 0; i < values.length - 1; i++) {
            int maxIndex = maks(values, i, values.length, comp);

            T temp = values[i];
            values[i] = values[maxIndex];
            values[maxIndex] = temp;

        }
    }
    public static class Person {
        String firstname;
        String lastname;

        Person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }


        public String toString() {
            return firstname + " " + lastname;
        }
    }
    public static void main(String[] args) {
        Person[] d = {new Person("Petter", "Pettersen"),
                new Person("Kari", "Pettersen"),
                new Person("Niles", "Abrahamsen"),
                new Person("Tor", "Tonsen")};

        AscendingPersonComparator compAsc = new AscendingPersonComparator();
        DesendingPersonComparator compDesc=new DesendingPersonComparator();
        //Lage sorterings-funksjonen som tar inn både person-arrayet og en sammenlikningsfunksjon

        System.out.println("Før sortering ");
        System.out.println(Arrays.toString(d));

        sort(d, compAsc);
        System.out.println("Etter sortering ");
        System.out.println(Arrays.toString(d));

        sort(d, compDesc);
        System.out.println("Etter sortering ");
        System.out.println(Arrays.toString(d));

    }

}
