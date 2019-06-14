import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final int size = 100000;
        int tmp1 = randomInRange(0, size);

        Array<Integer> array = new ArrayImpl<>();
        Array<Integer> array1 = new SortedArrayImpl<>(size);

        for (int i= 0; i < size; i++){
            int tmp = randomInRange(0, size);
            array.add(tmp);
        }

        for (int i= 0; i < size; i++){
            int tmp2 = randomInRange(0, size);
            array1.add(tmp2);
        }


        System.out.println("Size is " + array.size());
        System.out.println("Find 26: " + array.contains(26));
        System.out.println("Find 671: " + array.contains(671));
        System.out.println("Find tmp1: " + array.contains(tmp1));

        array.remove(2);
        System.out.println("Find index for 2: " + array.indexOf(2));

        System.out.println("sortBubble() Time " + array.sortBubble());
        System.out.println("sortSelect() Time " + array.sortSelect());
        System.out.println("sortInsert() Time " + array.sortInsert());


        System.out.println("SortedArrayImpl sortBubble() Time " + array1.sortBubble());
        System.out.println("SortedArrayImpl sortSelect() Time " + array1.sortSelect());
        System.out.println("SortedArrayImpl sortInsert() Time " + array1.sortInsert());

        System.out.println("Size is " + array1.size());
        System.out.println("Find 26: " + array1.contains(26));
        System.out.println("Find 671: " + array1.contains(671));
        System.out.println("Find tmp1: " + array1.contains(tmp1));

        array1.remove(2);
        System.out.println("Find index for 2: " + array1.indexOf(2));


    }
    
    public static int randomInRange(int min, int max) {

        return new Random().ints(1, min, max + 1).findFirst().getAsInt();
    }


}

