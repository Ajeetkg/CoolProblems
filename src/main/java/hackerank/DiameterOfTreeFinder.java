package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiameterOfTreeFinder {

    private static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return (node);
    }

    private static Node addRandomElement(Node node, int data, int index) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (index <= 2) {
                node.left = addRandomElement(node.left, data, index);
            } else {
                node.right = addRandomElement(node.right, data, index);
            }

        }
        return (node);
    }

    /* Write your custom functions here */
    static int diameterOfTree(Node root) {
/* For your reference
   class Node {
       Node left, right;
       int data;
               Node(int newData) {
           left = right = null;
           data = newData;
       }
   }
*/
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
       // BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        Node _root;
        int root_i = 0, root_cnt = 0, root_num = 0;
        _root = null;
        int isBst = in.nextInt();
        root_cnt = in.nextInt();
        for (root_i = 0; root_i < root_cnt; root_i++) {
            root_num = in.nextInt();
            if (isBst == 0) {
                _root = addRandomElement(_root, root_num, root_i);
            } else {
                _root = insert(_root, root_num);
            }
        }

        System.out.println(print(_root));
      //  bw.write(String.valueOf(diameterOfTree(_root)));
       // bw.newLine();
       // bw.close();
        return;
    }

    private static String print(Node node){


        if(node != null){
            if(node.left != null){
                System.out.println(node.data);
                print(node.left);
                print(node.right);

            }else if(node.right != null){
                System.out.println(node.data);
                print(node.left);
                print(node.right);

            }
        }
        return "Success";
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

}

