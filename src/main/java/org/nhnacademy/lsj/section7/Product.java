package org.nhnacademy.lsj.section7;

/**
 * 마트에서 납품받거나 , 손님에게 팔 물건 class.
 */
public class Product {

    private final String name;
    private final int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", cost=" + cost;
    }
}
