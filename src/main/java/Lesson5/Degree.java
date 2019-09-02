package Lesson5;

public class Degree {

    public static void main(String[] args) {

        float number = 3.5f;
        int degree = 5;

        System.out.println(degreeNumber(number, degree+1));
    }

    public static float degreeNumber(float number, int degree){

        if (degree == 1 || degree == 0)
            return 1;
        if (degree > 0)
            return number * degreeNumber(number, --degree);
        else
            if (degree < 0)
                return 1/ (number * degreeNumber(number,  Math.abs(--degree)));
        return 1;
    }
}
