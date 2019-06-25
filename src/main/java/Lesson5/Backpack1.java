package Lesson5;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Backpack1 {

    Set<Goods> goods ;
    private Set<String> result = new HashSet<>();

//    public Backpack1(Set<Goods> goods) {
//        this.goods = goods;
//    }
//
//    public void getBackpack1() {
//        if (word.length == 1) {
//            System.out.println(word[0]);
//            return;
//        }
//
//        getAnagramm(word.length);
//
//        for (String anagramm : result) {
//            System.out.println(anagramm);
//        }
//    }
//
//    private void getAnagramm(int length) {
//        if (length == 1) {
//            return;
//        }
//
//        for (int i = 0; i < length; i++) {
//            getAnagramm(length - 1);
//            showResult();
//            result.add(String.valueOf(word));
//            rotate(length);
//        }
//    }
//
//    private void rotate(int length) {
//        int pos = word.length - length;
//        char temp = word[pos];
//        for (int i = pos + 1; i < word.length; i++) {
//            word[i - 1] = word[i];
//        }
//        word[word.length - 1] = temp;
//    }
//
//    private void showResult() {
//        for (char c : word) {
//            System.out.print(c);
//        }
//        System.out.println();
//    }
//
//
//    public static void main(String[] args) {
//
//        Set<Goods> goods = new LinkedHashSet<>();
//        goods.add(new Goods("book", 1.0f, 600f));
//        goods.add(new Goods("binoculars", 2.0f, 5000f));
//        goods.add(new Goods("kit", 4.0f, 1500f));
//        goods.add(new Goods("notebook", 2.0f, 40000f));
//        goods.add(new Goods("pot", 1.0f, 500f));
//        goods.Backpack1();
//    }
}
