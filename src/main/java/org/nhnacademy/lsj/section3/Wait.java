package org.nhnacademy.lsj.section3;

public interface Wait {

     default void waitThread(){
        try{  // 파이프 채워지면 기다림
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }


}
