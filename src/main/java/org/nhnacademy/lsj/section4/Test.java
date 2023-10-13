package org.nhnacademy.lsj.section4;


import org.nhnacademy.lsj.section3.Wait;

public class Test implements Wait {


    /**
     두개의 스레드가 두개의 리소스를 공유하면서 .
     하나의 리소스 획득 후 다른 리소스를 기다리면서 발생할 수 있는 교착 상태를 만들어 보자.
     */

    public static void main(String[] args) {

        Object object = new Object();
        Object object2 = new Object();


        Thread task1 = new Thread(() -> {

            synchronized (object){

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }


                synchronized (object2){

                    System.out.println("Thread1 " + object2);
                }


            }

            System.out.println("여기까지 안와");

        });


        Thread task2 = new Thread(() -> {

          synchronized (object2){

              try{
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
              }


              synchronized (object){
                  System.out.println("Thread2 " + object);
              }

          }

            System.out.println("여기까지 안와");

        });


        task1.start();
        task2.start();


    }

}

