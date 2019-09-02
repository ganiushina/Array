package Lesson4;

import java.util.Iterator;

public interface LinkedList<E> extends Iterable<E>   {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(Object value);

    boolean contains(Object value);

    boolean isEmpty();

    int size();

    void display();

    E getFirstElement();

    Entry getFirst();


    static class Entry<E>  {
        public final E value;
        public Entry<E> next;

        public Entry(E value) {
            this.value = value;
        }


    }



}
