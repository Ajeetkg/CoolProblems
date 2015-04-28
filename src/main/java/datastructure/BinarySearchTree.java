package datastructure;

import com.sun.org.apache.bcel.internal.generic.DUP;

/**
 * Created by Ajeet on 4/13/2015.
 */
public class BinarySearchTree {
    BinaryNode root;

    public void insert(BinaryNode binaryNode){
        if(null == root){
            root = binaryNode;
        }else{

        }
    }

    public void remove(BinaryNode binaryNode){

    }

    public Comparable find(BinaryNode binaryNode){

        return binaryNode.element;
    }

    class BinaryNode {
        Comparable element;
        BinaryNode left, right;
        BinaryNode(Comparable element ){
            this.element = element;
            left = right =null;
        }
    }

    class DuplicateItemException extends RuntimeException{
        DuplicateItemException(){
            super();
        }

        public DuplicateItemException(String message){
            super(message);
        }
    }

    class ItemNotFoundException extends RuntimeException{
        ItemNotFoundException(){
            super();
        }

        public ItemNotFoundException(String message){
            super(message);
        }
    }
}
