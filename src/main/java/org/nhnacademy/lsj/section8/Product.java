package org.nhnacademy.lsj.section8;


/**
 * 마트에서 납품받거나 , 손님에게 팔 물건 class.
 */
public class Product {

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name = " + name + '\'' + ", cost=" + cost + ", index=" + index ;
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

    /**
     * 물품의 생성자.
     *
     * @param name  물품 이름.
     * @param cost  물품 가격.
     * @param index 물품의 번호.
     */
    public Product(String name, int cost, int index) {
        this.name = name;
        this.cost = cost;
        this.index = index;
    }

}