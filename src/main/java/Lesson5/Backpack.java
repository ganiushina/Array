package Lesson5;


import java.util.*;

public class Backpack {

    public static float maxW = 7.0f;

    public static void main(String[] args) {

        int tmp = 0;
        Map<Set<Goods>, Float> goodsBestMap  = new HashMap<>();

        Set<Goods> goods = new LinkedHashSet<>();
        goods.add(new Goods("book", 1.0f, 600f));
        goods.add(new Goods("binoculars", 2.0f, 5000f));
        goods.add(new Goods("kit", 4.0f, 1500f));
        goods.add(new Goods("notebook", 2.0f, 40000f));
        goods.add(new Goods("pot", 1.0f, 500f));

        putGoods(goods, tmp, goodsBestMap);
    }


    private static void putGoods(Set<Goods> goods, int tmp, Map<Set<Goods>, Float> goodsBestMap) {

        float tmpWeight = 0;
        float tmpCost = 0;

        Set<Goods> goodsBest = new LinkedHashSet<>();

        for (Goods item : goods) {
            tmpWeight = tmpWeight + item.weight;


            if (tmpWeight < maxW) {
                goodsBest.add(item);
                tmpCost = tmpCost + item.cost;
            } else if (tmpWeight == maxW) {
                goodsBest.add(item);
                tmpCost = tmpCost + item.cost;
                break;
            } else if (tmpWeight > maxW) {
                tmpWeight = tmpWeight - item.weight;
            }
        }

        goodsBestMap.put(goodsBest, tmpCost);

        rotate(goods, tmp);
        tmp++;
        if (tmp == goods.size()){
            bestProce(goodsBestMap);
            return;
        }
        putGoods(goods, tmp, goodsBestMap);
    }

    private static void bestProce(Map<Set<Goods>, Float> goodsBestMap) {

        Float tmpCost1 = Float.valueOf(0);
        Set<Goods> goods1 = new LinkedHashSet<>();

        for(Map.Entry entry : goodsBestMap.entrySet()){
            goods1 = Collections.max(goodsBestMap.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();
            tmpCost1 = Collections.max(goodsBestMap.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getValue();
        }

        for (Goods item : goods1) {
            System.out.println("the best goods is " +  item.name );
        }

        System.out.println( "cost is " + tmpCost1);
    }

    private static void rotate(Set<Goods> goods, int pos) {

        Goods arr[] = new Goods[goods.size()];
        arr = goods.toArray(arr);

        goods.remove(arr[pos]);
        goods.add(arr[pos]);

    }




}
