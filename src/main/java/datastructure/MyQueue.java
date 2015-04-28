package datastructure;

/*
    Implement a queue using arrays
    Consider all boundary conditions like queue size full, queue empty, etc.
    The queue should be able to accept the size of queue as an input (can be anything from 1 thru n where n could be million +)
*/

import java.util.Iterator;

public class MyQueue{

    private static int[] queueArray;
    private static int startIndex, lastIndex, countElement=0;

    public MyQueue(int size){
        queueArray = new int[size];
    }

    public static void main(String[] args){
        //queue size is already defined

    }

    public static void enqueue(int data){
        //check if the queue is empty, if empty add element right away
        //else, check whether the queue size is full, if it yes, then return that further queueing is not possible
        //need to insert the element at the oth position, Shift the other element to the right


        //If the queue is empty , add element at the middle of the array. Set startIndex and lastindex to the middle point
        // If the queue is not empty, then find out the startindex, and add element at startIndex-1

        MyQueue myQueue = new MyQueue(50);
        int size = myQueue.queueArray.length;
        if(myQueue.countElement == 0){
            myQueue.queueArray[size/2] = data;
            myQueue.startIndex=size/2;
            myQueue.lastIndex=size/2;
            myQueue.countElement++;

        }else{
            myQueue.queueArray[myQueue.startIndex-1]=data;
            myQueue.startIndex=myQueue.startIndex-1;
            myQueue.countElement++;
        }



    }

    public static int dequeue(){
        //if the queue is empty, return "message that not element found"
        //else, find the element at the lastIndex, set the lastIndex to pointer to lastIndex-1

        Iterator<String> iter = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };
        try {
            if (queueArray.length == 0) {
                //throw No elment found exception
            } else {
                lastIndex = lastIndex - 1;
                return queueArray[lastIndex];

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int checkBoundaryConditions(){
        //call check QueueEmpty method
        //call check QueueSizeFull method
        return 0;
    }




}




class MySingleton{

    private static MySingleton instance;

    private MySingleton(){
    }

    public static MySingleton getInstance(){

        if(instance == null){
            instance = new MySingleton();
        }

        return instance;
    }

}

