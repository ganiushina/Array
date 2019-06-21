package Lesson4;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterator<E> {
//public class SimpleLinkedListImpl<E> implements LinkedList<E>  {

    protected Entry<E> firstElement;//001[005]
    protected int size;

    @Override//O(1)
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);//002[007]
        entry.next = firstElement;//007[...next->005]
        firstElement = entry;//001[007]
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
        return this;
    }

    @Override
    public boolean hasNext() {
      //  Entry<E> current = this.firstElement;
        return firstElement.next != null || firstElement.value !=null;
//        if (current.next != null) {
//            return true;
//        }
//        else
//        return false;
    }

    @Override
    public E next() {
//        E current = firstElement.value;
//        E previous = null;
        Entry<E> current = firstElement;
        Entry<E> previous = null;
        //while (current != null) {
        //    System.out.println(current.value);
           // firstElement = current.next;
        if (current != null){
            previous = current;
            firstElement = current.next;
       }

        return previous.value ;

//        Entry<E> current = firstElement;
//        E value = current.value; // значение в текущем узле
//        firstElement = firstElement.next;     // следующий узел
//        return value;
    //    Entry<E> current = firstElement;
       // return firstElement.value;
//        Entry<E> current = firstElement;
//        if (current.next != null) {
//            current = current.next;
//        }
//        return current.value;
    }

//    @Override
//    public Iterator<E> iterator() {
//        Iterator<E> it = new Iterator<E>() {
//
//            private int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < size && firstElement.next.value != null;
//            }
//
//            @Override
//            public E next() {
//                return firstElement.value;
//            }
//
//            @Override
//            public void remove() {
//                throw new UnsupportedOperationException();
//            }
//        };
//        return it;
//    }

//    public Iterator<E> iterator() {
//        return new MyLinkedListIterator();
//    }
//
//    private class MyLinkedListIterator implements Iterator<E> {
//
//        private MyListNode curr;
//
//        public MyLinkedListIterator() {
//            this.curr = SimpleLinkedListImpl.this.head; // голова списка
//        }
//
//        public boolean hasNext() {
//            return this.curr != null;
//        }
//
//        public E next() {
//            if (!this.hasNext()) {
//                throw new NoSuchElementException();
//            }
//            E value = curr.value; // значение в текущем узле
//            curr = curr.next;     // следующий узел
//            return value;
//        }
//
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//    }
}
