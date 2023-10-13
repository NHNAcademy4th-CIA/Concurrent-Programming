package org.nhnacademy.lsj.section4;

public class TestCounter {


    /**
     * Counter 클래스를 만들고, 두개의 스레드를 이용해 증가시켜 보자.
     */
    private static int countNumber = 0;


    public static void main(String[] args) {
        Counter counter = new Counter();
        int numberOfIterations = 100000000;

        CountAgent agent1 = new CountAgent(counter, numberOfIterations, true);
        CountAgent agent2 = new CountAgent(counter, numberOfIterations, false);


        agent1.start();
        agent2.start();

        long start = System.currentTimeMillis();

        try {
            agent1.join();
            agent2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Count : " + counter.getCounter());

        long end = System.currentTimeMillis();

        System.out.println("Synchronized Time : " + (end - start));


        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfIterations; i++) {
                    countNumber++;
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfIterations; i++) {
                    countNumber--;
                }
            }
        };


        start = System.currentTimeMillis();
        Thread thread = new Thread(r);
        Thread thread2 = new Thread(r2);

        thread.start();
        thread2.start();
        end = System.currentTimeMillis();

        System.out.println("Count : " + countNumber);

        System.out.println("aSynchronized Time : " + (end - start)); // Synchronized 없는게 확실히 더 빠름


    }
}