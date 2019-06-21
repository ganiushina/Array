package Lesson4;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;

    @Override//O(1)
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.next = firstElement;
        firstElement = entry;
        size++;
    }

    @Override//O(1)
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E removedValue = this.firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedValue;
    }

    @Override
    public boolean remove(Object value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {//previous == null
            firstElement = firstElement.next;//current.next
        }
        else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(Object value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("----------");
        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("----------");
    }

    @Override
    public E getFirstElement() {
        return firstElement.value;
    }

    @Override
    public Entry getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            Entry<E> currentIndex = firstElement;

            @Override
            public boolean hasNext() {
              return currentIndex != null ;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Entry<E> current = currentIndex;
                currentIndex = currentIndex.next;
                return current.value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}
