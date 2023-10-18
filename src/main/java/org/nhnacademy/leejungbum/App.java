package org.nhnacademy.leejungbum;

/**
 * Hello world!
 *
 */
public class App
{

    public static class Test extends Thread{
        @Override
        public void run(){
            System.out.println("test");
        }
    }
    public static void main( String[] args )
    {
        Test test =  new Test();
        test.start();

    }
}
