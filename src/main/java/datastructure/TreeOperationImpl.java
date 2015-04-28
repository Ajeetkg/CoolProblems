package datastructure;

/**
 * Created by Ajeet on 4/17/2015.
 *
 *
 */
public class TreeOperationImpl implements TreeOperation{
    Node head;
    public Node getParents(Node node){
        /**
         * Get the head node
         * Write the end condition that if the label is equal, then return the node.
         * Otherwise, recursively call the getParent method
         */
        return null;
    }

    public String printParentPath(Node node){
        return null;
    }

    private void push(String data){
        Node currentNode = new Node(data);
        if(null == head){
            head = currentNode;
        }
        Node iteratorNode = head;
        while(iteratorNode != null){
            if(iteratorNode.leftNode == null){

            }
        }

    }
}

interface TreeOperation{
        Node getParents(Node node);
        String printParentPath(Node node);
}

class Node{
    Node leftNode, rightNode;
    String label;

    public Node(String value){
        this.label = value;
    }
}
