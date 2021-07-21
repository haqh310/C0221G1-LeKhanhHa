package bai12_java_collection_framework.thuc_hanh.cai_dat_cay_tim_kiem_nhi_phan;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size;

    public BST() {
    }

    public BST(E[] object) {
        for (int i = 0; i < object.length; i++) {
            insert(object[i]);
        }
    }

    protected TreeNode<E> creatNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = creatNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = creatNewNode(e);
            } else {
                parent.right = creatNewNode(e);
            }
        }
        size++;
        return true;
    }

    @Override

    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }
}
