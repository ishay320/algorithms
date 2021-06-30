package Max_SubArray;

import java.util.Arrays;

public class Max_Subarray{


    public static void main(String[] args){
        int[] arr = {1,2,3,-10,5,-1};
        int[][] mat = max_sub_matrix(arr);
        System.out.println(Arrays.deepToString(mat));
    }

public static int[][] max_sub_matrix(int[] array){
    int[][] mat = new int[array.length][array.length];

    for (int i = 0; i < array.length; i++) {
        mat[i][i] = array[i];
        for (int j = i+1; j < array.length; j++) {
            mat[i][j] = array[j]+mat[i][j-1];
        }
    }
    return mat;
}
    public static int[] best_subarray(int[] array){
        int best = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        int temp_start = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum<0){
                sum = 0;
                temp_start = i+1;
            }
            if (best<sum){
                start = temp_start;
                end = i;
                best = sum;
            }
        }
        return Arrays.copyOfRange(array,start,end);
    }



}
