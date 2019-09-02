package Lesson3;

import Lesson3.queue.DequeImpl;
import Lesson3.queue.PriorityQueue;
import Lesson3.queue.Queue;
import Lesson3.queue.QueueImpl;
import Lesson3.stack.Stack;
import Lesson3.stack.StackImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new DequeImpl<>(6);
//        System.out.println(((DequeImpl<Integer>) queue).insertRight(3));
//        System.out.println(((DequeImpl<Integer>) queue).insertRight(5));
//        System.out.println(((DequeImpl<Integer>) queue).insertRight(1));
//        System.out.println(((DequeImpl<Integer>) queue).insertRight(2));
//        System.out.println(((DequeImpl<Integer>) queue).insertRight(6));
//        System.out.println(((DequeImpl<Integer>) queue).insertRight(4));


        System.out.println(((DequeImpl<Integer>) queue).insertLeft(3));
        System.out.println(((DequeImpl<Integer>) queue).insertLeft(5));
        System.out.println(((DequeImpl<Integer>) queue).insertLeft(1));
        System.out.println(((DequeImpl<Integer>) queue).insertLeft(2));
        System.out.println(((DequeImpl<Integer>) queue).insertLeft(6));
        System.out.println(((DequeImpl<Integer>) queue).insertLeft(4));

        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
        //    System.out.println(((DequeImpl<Integer>) queue).removeLeft());
            System.out.println(((DequeImpl<Integer>) queue).removeRight());
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();

        testString(str);
        in.close();
    }



    private static void testString(String str) {
        Stack<String> stackString = new StackImpl<>(str.length());

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length ; i++) {
            addToStackString(stackString, String.valueOf(charArray[i]));
        }

        StringBuilder sb = new StringBuilder(charArray.length);

        while (!stackString.isEmpty()) {
             sb.append(stackString.pop());
        }
        String str1 = sb.toString();
        System.out.println("Output string: " + str1);
    }

    private static void addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }

    private static void addToStackString(Stack<String> stack, String value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }
}



