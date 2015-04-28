package datastructure;

/**
 * Created by Ajeet on 3/29/2015.
 */
public class ReverseLinkedList {

    public static void main(String[] args){
        Node head = new Node(1);
        add(head,2);
        add(head,3);
        add(head,4);

        printNodes("List",head);
        head = reverseRecursiveSimple(head, null);
        printNodes("reverse", head);

    }

    private static  Node  recursiveReverse(Node list){
        if (list == null) return null; // first question

        if (list.next == null) return list; // second question

        // third question - in Lisp this is easy, but we don't have cons
        // so we grab the second element (which will be the last after we reverse it)

        Node secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        Node reverseRest = recursiveReverse(secondElem);

        // then we join the two lists
        secondElem.next = list;

        return reverseRest;
    }

    private static Node reverseRecursiveSimple(Node head, Node previous){
        System.out.println();
        if(previous != null && head != null)
            System.out.println("@@head="+head.data+", Previous="+previous.data);

        if(head == null) return null;
        if(head.next == null){
            head.next=previous;
            return head;
        }
        Node reverse=reverseRecursiveSimple(head.next,head);

        System.out.println();
        if(previous != null && head != null)
        System.out.println("head.next="+head.next.data+", Previous="+previous.data);

        head.next=previous;
        return reverse;
    }
    private static Node reverse(Node head){
        Node next;
        Node current=head;
        Node prev=null;

        while(current != null ){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        head=prev;

        return head;
    }
    private static Node add(Node head, int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;

    }
    private static void printNodes(String message, Node node){
        Node temp = node;
        System.out.println();
        System.out.println(message);
        while(temp != null){
            System.out.print(temp.data+",");
            temp = temp.next;
        }
    }
    private static class Node{
        int data;
        Node next;
        Node(){};
        Node(int data){
            this.data = data;
        }
    }
}
