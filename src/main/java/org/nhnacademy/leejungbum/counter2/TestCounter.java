package org.nhnacademy.leejungbum.counter2;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter1 = new Counter("Counter1");
        Counter counter2 = new Counter("Counter2");

        counter1.run();
        counter2.run();
    }
}

//현재 counter1 에 while문을 빠져나오지 못하고있다.