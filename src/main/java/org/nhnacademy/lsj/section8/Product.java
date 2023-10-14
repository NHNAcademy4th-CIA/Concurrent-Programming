package org.nhnacademy.lsj.section8;

public class Product {

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", index=" + index +
                '}';
    }

    public int getCost() {
        return cost;
    }



    private final String name;
    private final int cost;

    private final int index;

    public int getIndex() {
        return index;
    }

    public Product(String name, int cost, int index) {
        this.name = name;
        this.cost = cost;
        this.index = index;
    }

}