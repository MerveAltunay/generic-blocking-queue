package org.kodluyoruz;

public interface Queue<T>{

    T peek() ;

    T poll() throws Exception;

    void add(T data) throws Exception;

    boolean isEmpty();

    int size();

}
