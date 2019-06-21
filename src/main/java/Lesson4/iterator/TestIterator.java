package Lesson4.iterator;



import Lesson4.SimpleLinkedListImpl;

public class TestIterator {

    public static void main(String[] args) {

        Lesson4.LinkedList linkedList = new SimpleLinkedListImpl();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        for (Object value : linkedList) {
            System.out.println(value);
        }

    }
}
