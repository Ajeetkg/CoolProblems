package datastructure;

/**
 * Created by Ajeet on 3/30/2015.
 */
public class CustomQueue {

    Node first, last;

    public void enqueue(Object item){
        if(first == null){
            Node node = new Node(item);

        }
    }

    public void dequeue(){

    }
    private static class Node<T>{
        T data;
        Node next;

        Node(T data){
            this.data=data;
        }
    }
}
