package bai14_thuat_toan_sap_xep.bai_tap;

public class InsertionSort {
    static int[] list = {1, 9, 4,6,8,3};
    public static void insertionSort(int[] list){
        for(int i=1;i<list.length;i++){
           int j=i-1;
           int temp =list[i];
           while (temp<list[j]){
               list[j+1] = list[j];
               j--;
           }
           list[j+1] = temp;
        }
        for (int list1: list) {
            System.out.print(list1+" ");
        }
        
    }

    public static void main(String[] args) {
        for ( int lis1:list ) {
            System.out.print(lis1+" ");
        }
        System.out.println();
        insertionSort(list);
    }
}
