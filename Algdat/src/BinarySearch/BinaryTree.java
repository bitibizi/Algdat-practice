package BinarySearch;

import java.util.ArrayDeque;

public class BinaryTree {

    static class BinaryTreeNode {
        char value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;

        BinaryTreeNode(char value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        BinaryTreeNode addLeftChild(char value) {
            this.leftChild = new BinaryTreeNode(value);
            return this.leftChild;
        }

        BinaryTreeNode addRightChild(char value) {
            this.rightChild = new BinaryTreeNode(value);
            return this.leftChild;
        }


    }

    static void printlevelOrder(BinaryTreeNode root){
        ArrayDeque<BinaryTreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);

        while(!queue.isEmpty()){

            BinaryTreeNode current=queue.removeFirst();

            if(current.leftChild!=null){
                queue.addLast(current.leftChild);
            }

            if(current.rightChild!=null){
                queue.addLast(current.rightChild);
            }

            System.out.println(current.value+" ");

        }
    }

    public static void main(String[] args) {
        //nivå0
        BinaryTreeNode root = new BinaryTreeNode('A');
        //nivå1
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');
        //nivå2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        printlevelOrder(root);

    }


}
