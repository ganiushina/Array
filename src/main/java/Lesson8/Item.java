package Lesson8;

import java.util.Objects;

public class Item {

    private int id;
    private String title;
    Item next;

    public Item(int id, String title) {
        this.id = id;
        this.title = title;
        this.next = null;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return id;
        //return Objects.hash(id);
    }
}
