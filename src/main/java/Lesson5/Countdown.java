package Lesson5;

public class Countdown {

    public static void main(String[] args) {
//        countDownLoop(5);
        countDownRecursion(0);
    }

    private static void countDownRecursion(int n) {
//        if (n > 0) {
            System.out.println(n);
            countDownRecursion(--n);
//        }
    }

    private static void countDownLoop(int n) {
        while (n > 0) {
            System.out.println(n);
            n--;
        }
    }
}
