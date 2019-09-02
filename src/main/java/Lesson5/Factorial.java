package Lesson5;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    //5! = 5 * 4 * 3 * 2 * 1 = 120
    //3! = 3 * 2 * 1 = 6
    //1! = 1
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
