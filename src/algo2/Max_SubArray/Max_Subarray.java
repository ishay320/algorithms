package algo2.Max_SubArray;

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

    /**
     * O(n)
     * @param array
     * @return
     */
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

    /**
     * need testing
     * O(n*m^2)
     * @param mat
     * @return
     */
    public static int[][] super_best(int[][] mat){
        int best = Integer.MIN_VALUE;
        int start_line = 0;
        int end_line = 0;

        int start_column = 0;
        int end_column = 0;
        int[][] sum_mat = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) { // init the sum matrix
            for (int j = 0; j < mat[0].length; j++) {
                if (i==0){
                    sum_mat[i][j] = mat[i][j];
                }else {
                    sum_mat[i][j] = mat[i][j]+sum_mat[i-1][j];
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat.length; j++) {
                int algo_sum = 0;
                int algo_start = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    if (i==0) {
                        algo_sum += sum_mat[j][k];
                    }else {
                        algo_sum += sum_mat[j][k] - sum_mat[i][k];
                    }
                    if (algo_sum<0){
                        algo_sum = 0;
                        algo_start = k;
                    }else
                        if (algo_sum>best){
                        best = algo_sum;
                        start_line = i; // check if i+1
                        end_line = j;
                        start_column = algo_start;
                        end_column = k;
                    }
                }
            }
        }
        int[][] mat_return = new int[end_line - start_line][end_column - start_column];
        for (int i = start_line; i < mat.length; i++) {
            for (int j = start_column; j < mat[0].length; j++) {
                mat_return[i-start_line][j-start_column] = mat[i][j];
            }
        }
        return mat_return;
    }
}
