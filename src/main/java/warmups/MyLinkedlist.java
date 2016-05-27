package warmups;

/**
 * Created by agupta2 on 5/23/16.
 */
public class MyLinkedlist {

    Node list;

    public void add( int data){
        Node node = new Node(data);
        if(null == list){
            list=node;
        } else{
            // iterate through list till it reaches the end.
            // And add the element at the end.
        }
    }

    public Node get(int index){
        //if null, return null

        // if only one, return top
        // if more, then return the top one
        return null;
    }

}


class Node{

    int data;
    Node next;

    Node( int data){
       this.data = data;
        this.next = null;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
