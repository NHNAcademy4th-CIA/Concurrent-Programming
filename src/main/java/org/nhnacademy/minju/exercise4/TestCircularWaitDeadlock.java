package org.nhnacademy.minju.exercise4;

/**
 * 스레드 1은 리소스 2에 대한 접근 권한을 가진 상태에서 리소스 1에 대한 접근 권한을 기다리고,
 * 스레드 2는 리소스 1에 대한 접근 권한을 가진 상태에서 리소스 2에 대한 접근 권한을 기다린다.
 * 두개의 스레드는 서로가 다른 스레드가 가지고 있는 접근 권한을 얻기 위해 대기 하고 있어
 * 하나의 스레드가 먼저 해제 하지 않는 이상 대기 상태는 계속해서 유지된다.
 */
public class TestCircularWaitDeadlock {
    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread task1 = new Thread(() -> {
            synchronized (resource1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (resource2) {
                    System.out.println("in task1 : " + resource2);
                }
            }
        });
        Thread task2 = new Thread(() -> {
            synchronized (resource2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (resource1) {
                    System.out.println("in task2 : " + resource1);
                }
            }
        });

        task1.start();
        task2.start();
    }
}
