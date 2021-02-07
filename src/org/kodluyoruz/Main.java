package org.kodluyoruz;


public class Main {

    public static void main(String[] args) {

        try {

            MyQueue myQueue = new MyQueue();

            MyThread thread1 = new MyThread(myQueue);
            MyThread thread2 = new MyThread(myQueue);


            thread1.start();
            thread2.start();

            try {

                thread1.join();
                thread2.join();

            }

            catch (InterruptedException e) {
                System.out.println("Main thread is interrupted");
            }

            System.out.println("Main thread is finishing");

        }
        catch (RuntimeException ex){
            System.out.println("Fatal error, program terminated");
        }

    }
}
