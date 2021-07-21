package bai12_java_collection_framework.bai_tap;

public class DeleteBST extends BinarySearchTree {
    public static  TreeNode minimumElement(TreeNode root){
        if(root.left == null){
            return root;
        }
        else {
            return minimumElement(root.left);
        }
    }
    public static TreeNode deleteNode(TreeNode root, int value){
        if(root == null){
            return null;
        }
       if(root.data >value){
           root.left = deleteNode(root.left,value);
       }
       else if(root.data < value){
           root.right = deleteNode(root.right,value);
       }
       else {
           if(root.left != null & root.right != null){
               TreeNode temp = root;
               TreeNode minNodeForRight = minimumElement(temp.right);
               root.data = minNodeForRight.data;
               root.right = deleteNode(root.right,minNodeForRight.data);
           }
           else if(root.left !=null){
               root = root.left;
           }
           else if(root.right !=null){
               root = root.right;
           }
           else {
               root =null;
           }
       }
       return root;
    }

    public static void main(String[] args) {
        TreeNode root =createBinarySearchTree();
        PostOrder(root);
        deleteNode(root,50);
        System.out.println("\n");
        PostOrder(root);
    }
}
