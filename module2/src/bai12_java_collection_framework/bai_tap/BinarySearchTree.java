package bai12_java_collection_framework.bai_tap;

import javax.swing.tree.TreeNode;

public class BinarySearchTree {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
        }
    }
    public static TreeNode insert(TreeNode root, TreeNode e){
        if(root == null){
            root =e;
            return root;
        }
        if(root.data > e.data){
            if(root.left == null){
                root.left=e;
            }
            else {
                insert(root.left,e);
            }
        }
        else if(root.data < e.data){
            if(root.right == null){
                root.right =e;
            }
            else {
                insert(root.right,e);
            }
        }
        return root;
    }
    public static void PostOrder(TreeNode root){
        if(root!=null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    public static TreeNode createBinarySearchTree(){
        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);
        TreeNode node5 = new TreeNode(5);
        TreeNode node55 = new TreeNode(55);
        insert(null,rootNode);
        insert(rootNode,node20);
        insert(rootNode,node10);
        insert(rootNode,node30);
        insert(rootNode,node60);
        insert(rootNode,node50);
        insert(rootNode,node70);
        insert(rootNode,node5);
        insert(rootNode,node55);
        return rootNode;
    }
    public static void main(String[] args) {
        TreeNode rootNode=createBinarySearchTree();
        TreeNode node13=new TreeNode(13);
        TreeNode root=insert(rootNode,node13);
        PostOrder(root);
    }
}
