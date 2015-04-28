package datastructure;

/**
 * Created by Ajeet on 3/20/2015.
 */
public class CustomizedLinkedList {

    private Node head;
    private int listSize;

    public CustomizedLinkedList(){

    }
    public static void main(String[] args){
        CustomizedLinkedList custLinkedList= new CustomizedLinkedList();
        custLinkedList.add(4);
        custLinkedList.add(3);
        custLinkedList.add(2);

        custLinkedList.toString();

    }


    public int size(){
        return this.listSize;
    }

    public void add(int data){
        this.listSize=listSize+1;
        Node temp = new Node(data, null);
        if(this.head == null){
            this.head=temp;
        }else{
            Node current=head;
            while(current.next != null){
                current=current.next;
            }
            current.next=temp;

        }
    }

    public String toString(){
        Node headIterator=this.head;
        while(headIterator.next!=null){
            System.out.print(headIterator.key + ", ");
            headIterator = headIterator.next;
        }
        System.out.println(headIterator.key+", "); //last node
        return null;
    }

    static class Node<T>{
        private T key;
        private Node next;

        public Node(){}
        public Node(T data){
            this.key=data;
            this.next=null;
        }
        public Node(T data, Node next){
            this.key= data;
            this.next=next;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
