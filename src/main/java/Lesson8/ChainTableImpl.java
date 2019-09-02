package Lesson8;



public class ChainTableImpl extends HashTableImpl{

    private Entry[] data;

    public ChainTableImpl(int maxSize) {
        super(maxSize);
        this.data = new Entry[maxSize*2];

    }


    @Override
    public boolean put(Item item, Integer cost) {
        size++;
        int index = hashFunc(item);
        Entry entry = new Entry(item, cost);
        if (data[index] == null)
            data[index] = entry;
        else {

            if (data[index].next != null) {
                Entry entryNew;
                entryNew = data[index];
                data[index] = entry;

                if (entryNew.next != null) {
                    data[index].next = entryNew;
                }
            } else {
                if (data[index].key.equals(item)) {
                    data[index].value = cost;
                    return true;
                } else
                    data[index].next = entry;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Item item) {
        
        int index = hashFunc(item);
        Entry entry = data[index];
        Entry entryPrev = null;

        while (entry != null) {
            if (entry.key.equals(item)) {
                if (entry.next == null) {
                    data[index] = null;
                    if (entryPrev != null) {
                        entryPrev.next = null;
                        data[index] = entryPrev;
                    }
                    return true;
                }

                if (entryPrev != null ) {
                    data[index] = null;
                    data[index] = entryPrev;
                    data[index].next = entry.next;
                    return true;
                }

                if (entryPrev == null ) {
                    data[index] = null;
                    data[index] = entry.next;
                    return true;
                }

            }
            entryPrev = entry;
            entry = entry.next;
        }
        return true;
    }

    @Override
    public Integer get(Item item) {
        int index = hashFunc(item);
        Entry entry = data[index];

        while (entry != null) {
            if (entry.key.equals(item)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return -1;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("\nEntry " + (i + 1) + " : ");
            Entry entry = data[i];
            while (entry != null) {
                System.out.print("Key: title " + entry.key.getTitle() + " id " + entry.key.getId() + " value " + entry.value + " ");
                entry = entry.next;
            }
        }
    }
}

