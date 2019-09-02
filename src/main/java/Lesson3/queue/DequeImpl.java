package Lesson3.queue;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

//    private static final int DEFAULT_TAIL = -1; Right front
//    private static final int DEFAULT_HEAD = 0; left rear


    public DequeImpl(int maxSize) {
        super(maxSize);
    }


    public boolean insertRight(E value) {
        return super.insert(value);
    }

    public boolean insertLeft(E value){
        if (isFull()) {
            return false;
        }
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        data[++tail] = value;
        size++;
        return true;
    }


    public E removeLeft() {
        return super.remove();
    }

    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
//
        if (head == lastIndex()) {
            tail = DEFAULT_HEAD;
        }

        E removedValue = data[tail--];
        size--;
        return removedValue;
    }

    @Override
    public E peek() {
        return super.peek();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }


}
