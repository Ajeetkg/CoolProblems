package datastructure;

/**
 * Created by Ajeet on 3/30/2015.
 */
public class Stack {

    Node top;

    public Node push(int data){
        Node  node = new Node(data);
        if(null == top){
            top = node;
        }else{
            node.next = top;
            top = node;
        }
        return top;
    }

    public Node pop(){
        Node node;
        if(top == null){
            return null;
        }else{
             node = top;
            top = top.next;
            node.next=null;

        }
        return node;
    }

    public int peek(){
        if(top != null){
            return top.data;
        }
        return 0;
    }

    //public void
    private static class Node{
        int data;
        Node next;
        public Node(){};
        public Node(int data){
            this.data = data;
        }
    }
}
