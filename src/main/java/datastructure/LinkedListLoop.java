package datastructure;

import sun.awt.image.ImageWatched;

import java.util.Hashtable;

/**
 * Created by Ajeet on 4/6/2015.
 */
public class LinkedListLoop {

    Node head;

    public static void main(String[] args){
        Hashtable<String,String> hashtable = new Hashtable<>();
        LinkedListLoop loop = new LinkedListLoop();
        loop.add(1);
        loop.add(2);
        loop.add(3);
        loop.add(4);
        loop.add(5);

        loop.get(5).next = loop.get(3);

       // loop.print(loop.head);
        System.out.println(loop.isLoop(loop.head));
    }

    private boolean isLoop(Node head){
        boolean isLoop =false;
        Node slower = head;
        Node faster = head;

        while(true){
            slower = slower.next;
            faster = faster.next.next;
            if(slower.next == null|| faster.next == null || faster.next.next == null ){
                isLoop = false;
                break;
            }

            if(slower == faster){
                isLoop = true;
                break;
            }
        }

        return isLoop;
    }

    private Node get(int data){
        Node current=head;
        while(current != null){
            if(current.data == data){
                break;
            }
            current = current.next;
        }
        return current;
    }
    private void add(int data){
        Node addedNode = new Node(data);
        if(head == null){
            head = addedNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = addedNode;
        }
    }
    private void print(Node head){
        Node nPrint=head;
        while(nPrint.next != null){
            System.out.println("Head Data: "+nPrint.data+", Next Data: "+nPrint.next.data);
            nPrint = nPrint.next;
        }
        System.out.println("Head Data: "+nPrint.data+", Next Data: "+nPrint.next);
    }


    static class Node<T>{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }

    }
}
