package bai12_java_collection_framework.bai_tap;

public class PreOrderBST extends BinarySearchTree {
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root=createBinarySearchTree();
        preOrder(root);
    }
}
