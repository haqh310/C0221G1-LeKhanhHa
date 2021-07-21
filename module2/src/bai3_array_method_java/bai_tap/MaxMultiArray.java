package bai3_array_method_java.bai_tap;

public class MaxMultiArray {
    public static void main(String[] args) {
        int[][] multiArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int max = multiArray[0][0];
        int posiX = 0;
        int posiY = 0;
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                if (max < multiArray[i][j]) {
                    max = multiArray[i][j];
                    posiX = i;
                    posiY = j;
                }
            }
        }
        System.out.printf("Max in array is multiArray[%d][%d] = %d",posiX,posiY,max);
    }
}
