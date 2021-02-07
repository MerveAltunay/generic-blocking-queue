package org.kodluyoruz;

public class MyQueue<T> implements Queue<T> {

    private Node<T> front, back;
    private int size;

    public MyQueue() {

        front = null;
        back = null;
        size = 0;
    }

    public synchronized T peek() {

        if (front != null) {
            return front.getData();
        } else {
            return null;
        }

    }

    public synchronized T poll(){

        T data = null;

        if (front != null) {
            Node<T> temp = front;
            front = front.getNext();
            data = temp.getData();
        }
        size--;
        System.out.println("The element is polled by " + Thread.currentThread().getName());
        notifyAll();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        return data;

    }

    public synchronized void add(T data){

        if(data == null){
            System.out.println("The added value is null");
            throw new NullPointerException("The null values cannot be added to the queue");
        }
        Node<T> temp = new Node<T>(data);
        if(isEmpty()){
            front = back = temp;
        }
        else{
            back.setNext(temp);
            back = temp;
        }
        size++;
        System.out.println("The added element is : " + data + " Thread name : " + Thread.currentThread().getName());
        notifyAll();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

    }

    public boolean isEmpty() {

        return (size == 0);
    }


    public int size() {

        return size;
    }
}
