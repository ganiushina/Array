package Lesson5;


import java.util.*;

public class Backpack {

    public static float maxW = 7.0f;



    public static void main(String[] args) {

        Set<Goods> goods = new LinkedHashSet<>();

        Map<Set<Goods>, Float> goodsBestMap  = new HashMap<>();

        goods.add(new Goods("book", 1.0f, 600f));
        goods.add(new Goods("binoculars", 2.0f, 5000f));
        goods.add(new Goods("kit", 4.0f, 1500f));
        goods.add(new Goods("notebook", 2.0f, 40000f));
        goods.add(new Goods("pot", 1.0f, 500f));
        int tmp = 0;

        putGoods(goods, tmp, goodsBestMap);
    }


    private static void putGoods(Set<Goods> goods, int tmp, Map<Set<Goods>, Float> goodsBestMap) {

        float tmpWeight = 0;
        float tmpCost = 0;

        Set<Goods> goodsBest = new LinkedHashSet<>();

        for (Goods item : goods) {
            tmpWeight = tmpWeight + item.weight;
            tmpCost = tmpCost + item.cost;

            if (tmpWeight < maxW) {
                goodsBest.add(item);
            } else if (tmpWeight == maxW) {
                goodsBest.add(item);
                break;
            } else if (tmpWeight > maxW) {
                tmpWeight = tmpWeight - item.weight;
            }
        }

        goodsBestMap.put(goodsBest, tmpCost);

        rotate(goods, tmp);
        tmp++;
        if (tmp == goods.size()){

            Float tmpCost1 = Float.valueOf(0);
            Set<Goods> goods1 = new LinkedHashSet<>();

            for(Map.Entry entry: goodsBestMap.entrySet()){
               if((Float) entry.getValue() > tmpCost1){
                   tmpCost1  = (Float) entry.getValue();
               }
            }

            for(Map.Entry entry: goodsBestMap.entrySet()){
                if(entry.getValue() == tmpCost1){
                    goods1 = (Set<Goods>) entry.getKey();
                }
            }
            for (Goods item : goods1) {
                System.out.println("the best goods is " +  item.name );
            }

            System.out.println( "cost is " + tmpCost1);
            return;
        }
        putGoods(goods, tmp, goodsBestMap);
    }

    private static void rotate(Set<Goods> goods, int pos) {

        Goods arr[] = new Goods[goods.size()];
        arr = goods.toArray(arr);

        goods.remove(arr[pos]);
        goods.add(arr[pos]);

    }




}
