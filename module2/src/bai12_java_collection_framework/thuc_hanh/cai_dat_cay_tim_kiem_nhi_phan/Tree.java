package bai12_java_collection_framework.thuc_hanh.cai_dat_cay_tim_kiem_nhi_phan;

public interface Tree<E> {
    boolean insert(E e);

    void inorder();

    int getSize();

}
