package org.nhnacademy.lsj.section8;

/**
 * 프로그램에서 사용되는 간단한 세마포어 , acquire , release구현.
 */
public class CustomSemaphore {

    private int count;

    public CustomSemaphore(int count) {
        this.count = count;
    }

    /**
     * 들어올 수 있는 count 감소  , 0이되면 스래드 일시 정지.
     *
     * @throws InterruptedException Exception.
     */
    public synchronized void acquire() throws InterruptedException {

        while (count == 0) {
            wait();
        }
        count--;
    }

    /**
     * 들어올 수 있는 스래드의 count 증가 , 아무 스래드 하나 꺠움.
     */
    public synchronized void release() {
        count++;
        notify();
    }


}
