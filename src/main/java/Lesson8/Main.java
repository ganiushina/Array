package Lesson8;

public class Main {

    public static void main(String[] args) {

      ChainTableImpl hashTableChain = new ChainTableImpl(5);

      hashTableChain.put(new Item(1, "Orange"), 150);
      hashTableChain.put(new Item(77, "Banana"), 100);
      hashTableChain.put(new Item(77, "Banana"), 228);
      hashTableChain.put(new Item(77, "Banana"), 300);
      hashTableChain.put(new Item(78, "Banana"), 300);
      hashTableChain.put(new Item(79, "Banana"), 300);
      hashTableChain.put(new Item(60, "Lemon"), 250);
      hashTableChain.put(new Item(52, "Milk"), 120);
      hashTableChain.put(new Item(21, "Potato"), 67);
      hashTableChain.put(new Item(22, "Potato"), 67);
      hashTableChain.display();

      System.out.println("\n-------------------------------");

      hashTableChain.remove(new Item(21, "Potato"));
      hashTableChain.remove(new Item(77, "Banana"));
      hashTableChain.remove(new Item(52, "Milk"));
      hashTableChain.display();

      System.out.println("\n-------------------------------");
      System.out.println("\n-------------------------------");

      System.out.println("Cost potato is " + hashTableChain.get(new Item(22, "Potato")));
      System.out.println("Cost banana is " + hashTableChain.get(new Item(78, "Banana")));



//      HashTable hashTable = new HashTableImpl(10);//5 * 2 = 10
//
//        hashTable.put(new Item(1, "Orange"), 150);
//        hashTable.put(new Item(77, "Banana"), 100);
//        hashTable.put(new Item(77, "Banana"), 228);
//        hashTable.put(new Item(60, "Lemon"), 250);
//        hashTable.put(new Item(52, "Milk"), 120);
//        hashTable.put(new Item(21, "Potato"), 67);
//
//        System.out.println("Size is " + hashTable.size());
//        hashTable.display();
//
//        System.out.println("Cost potato is " + hashTable.get(new Item(21, "Potato")));
//        System.out.println("Cost banana is " + hashTable.get(new Item(77, "Banana")));
//
//        hashTable.remove(new Item(21, "Potato"));
//        hashTable.remove(new Item(77, "Banana"));
//
//        System.out.println("Cost potato is " + hashTable.get(new Item(21, "Potato")));
//        System.out.println("Cost banana is " + hashTable.get(new Item(77, "Banana")));
//
//        hashTable.display();
    }
}
