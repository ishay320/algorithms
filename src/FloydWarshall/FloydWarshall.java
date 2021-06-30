package FloydWarshall;

public class FloydWarshall{
    public static void main(String[] args){

    }
     public static boolean[][] FWBasic(boolean[][] friendMat){ // O(n^3)
         int size = friendMat.length;
         boolean[][] mat = new boolean[size][size];
         for (int i = 0; i < size; i++) { //copy
             for (int j = 0; j < size; j++) {
                 mat[i][j] = friendMat[i][j];
             }
         }
         for (int k = 0; k < size; k++) { //the algo
             for (int i = 0; i < size; i++) {
                 for (int j = 0; j < size; j++) {
                     mat[i][j] = (mat[i][k] && mat[k][j]) || mat[i][j];
                 }
             }
         }
         return mat;
    }

    public static int[][] FWPath(int[][] friendMat){
        int size = friendMat.length;
        int[][] mat = new int[size][size];
        for (int i = 0; i < size; i++) { //copy
            for (int j = 0; j < size; j++) {
                if (mat[i][j]==0&&i!=j){
                    friendMat[i][j] = Integer.MAX_VALUE;
                }
                else{
                    mat[i][j] = friendMat[i][j];
                }
            }
        }
        for (int k = 0; k < size; k++) { //the algo
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = Math.min(mat[i][k] + mat[k][j],  mat[i][j]);
                }
            }
        }
        return mat;
    }



}
