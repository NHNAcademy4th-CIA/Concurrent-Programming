package org.nhnacademy.lsj.section3;

/**
 * Thread.sleep() 작업을 위한 interface.
 */
public interface Wait {

    /**
     * Thread.sleep().
     */
    default void waitThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
