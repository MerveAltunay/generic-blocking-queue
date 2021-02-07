package org.kodluyoruz;

public class MyThread<T> extends Thread{

    MyQueue myQueue;

    public MyThread(MyQueue myQueue) {
        super();
        this.myQueue = myQueue;

    }

    public void run(){

        System.out.println(Thread.currentThread().getName()+" is starting");

        for(int i=0;i<=5;i++){
            myQueue.add(i);
        }

        myQueue.add("Kodluyoruz1");
        myQueue.add("Kodluyoruz2");


        System.out.println("The size of queue now: " + myQueue.size());

        myQueue.poll();
        myQueue.poll();
        myQueue.poll();
        myQueue.poll();

        System.out.println("The size of queue now: " + myQueue.size());

        System.out.println(Thread.currentThread().getName()+" is finished");


    }

}
