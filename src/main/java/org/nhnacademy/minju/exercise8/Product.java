package org.nhnacademy.minju.exercise8;

public class Product {
    private String itemName;
    private int itemCount;

    public Product(String itemName, int itemCount) {
        this.itemName = itemName;
        this.itemCount = itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemCountIncrement() {
        itemCount++;
    }
    public void setItemCountDecrement() {
        itemCount--;
    }
}
