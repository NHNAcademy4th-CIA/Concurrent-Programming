package org.nhnacademy.lsj.section4;

import java.util.concurrent.Semaphore;

/**
 * 연습 5-5. 여러개의 스레드가 제한된 수의 공유 자원을 이용하려 한다. 관련 예제를 만들어 본다.
 * 옷을 팔고 있는 가게에 10명의 손님이 있다.
 * 손님은 옷을 고른 후 탈의실에서 입어 보려 한다.
 * 하지만, 탈의실은 5개만 있다.
 */
public class TestClothingStore {
    // 세마포어를 통해서 한번에 5명만 입장 가능하도록 만듦.
    static Semaphore dressrooms = new Semaphore(5);

}

class Cloth implements Runnable {

    @Override
    public void run() {
        try {

            // 세마포어를 통해서 한번에 5명만 입장 가능하도록 만듦.
            TestClothingStore.dressrooms.acquire();
            System.out.println("옷 입기");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            TestClothingStore.dressrooms.release();
            System.out.println("옷 입기 종료 ! ");
        }

    }

}
