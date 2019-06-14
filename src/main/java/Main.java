import java.util.Random;

public class Main {
    public static void main(String[] args)  {

        final int size = 100000;
        int tmp1 = randomInRange(0, size);

        Array<Integer> array = new ArrayImpl<>();
        Array<Integer> array1 = new ArrayImpl<>();
        Array<Integer> array2 = new ArrayImpl<>();

        Array<Integer> array3 = new SortedArrayImpl<>(size);
        Array<Integer> array4 = new SortedArrayImpl<>(size);
        Array<Integer> array5 = new SortedArrayImpl<>(size);

        for (int i= 0; i < size; i++){
            int tmp = randomInRange(0, size);
            array.add(tmp);
            array1.add(tmp);
            array2.add(tmp);
            array3.add(tmp);
            array4.add(tmp);
            array5.add(tmp);
        }


        System.out.println("Size is " + size);
        System.out.println("Find 26: " + array.contains(26));
        System.out.println("Find 671: " + array.contains(671));
        System.out.println("Find tmp1: " + array.contains(tmp1));


        array.remove(2);
        System.out.println("Find index for 2: " + array.indexOf(2));

        System.out.println("array sortBubble() Time " + array.sortBubble() + " millesec");
        System.out.println("array1 sortSelect() Time " + array1.sortSelect()+ " millesec");
        System.out.println("array2 sortInsert() Time " + array2.sortInsert()+ " millesec");

        System.out.println("array3 sortBubble() Time " + array3.sortBubble() + " millesec");
        System.out.println("array4 sortSelect() Time " + array4.sortSelect()+ " millesec");
        System.out.println("array5 sortInsert() Time " + array5.sortInsert()+ " millesec");

    }

    public static int randomInRange(int min, int max) {

        return new Random().ints(1, min, max + 1).findFirst().getAsInt();
    }


}

