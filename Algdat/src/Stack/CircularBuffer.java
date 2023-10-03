package Stack;

public class CircularBuffer {
    char[] buffer;
    int size;
    int head; //peker til starten av køen
    int tail; // peker til slutten av køen
    int count; // antall elementer som er i kønen nå

    CircularBuffer(int size) {
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    void pushBack(char value) {
        if (count + 1 > size) {
            throw new IllegalArgumentException();
        }
        this.buffer[tail] = value;
        tail = (tail + 1) % size;
        count = count + 1;
    }

    char popFront() {
        if (count <= 0) {
            throw new IndexOutOfBoundsException();
        }
        char retval = buffer[head];
        System.out.print(head);
        head = (head + 1) % size;
        count = count - 1;
        return retval;
    }

    int count() {
        return count;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(6);
        char[] values = "ABCDEFGHIJKLMNOPQRST".toCharArray();
        for (int i = 0; i < values.length; ) {
            for (int j = 0; j < buffer.size; j++) {
                if (values.length > i + j) {
                    buffer.pushBack(values[i + j]);
                }
            }

            while (buffer.count() > 0) {
                System.out.print(buffer.popFront());
            }

            System.out.println();

            i = i + 6;
        }


    }
}
