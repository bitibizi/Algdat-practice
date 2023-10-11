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
            return this.rightChild;
        }


    }

    static void printlevelOrder(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {

            BinaryTreeNode current = queue.removeFirst();

            if (current.leftChild != null) {
                queue.addLast(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.addLast(current.rightChild);
            }

            System.out.println(current.value + " ");

        }
    }

    static void printPreOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    static void printInOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        printInOrder(node.leftChild);
        System.out.print(node.value + " ");
        printInOrder(node.rightChild);
    }

    static void iterativFunksjonPre(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.removeLast();

            if (current.rightChild != null) {
                stack.addLast(current.rightChild);
            }
            if (current.leftChild != null) {
                stack.addLast(current.leftChild);
            }

            System.out.print(current.value+" ");


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


        System.out.print("Preorder is ");
        printPreOrder(root);
        System.out.println(" ");
        System.out.print("Inorder is ");
        printInOrder(root);

        System.out.println(" ");
        iterativFunksjonPre(root);

    }


}
