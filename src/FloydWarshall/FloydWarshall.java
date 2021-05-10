package FloydWarshall;

public class FloydWarshall{
     public static void FWBasic(boolean[][] friendMat){
         int size = friendMat.length;
         for (int k = 0; k < size; k++) {
             for (int i = 0; i < size; i++) {
                 for (int j = 0; j < size; j++) {
                     friendMat[i][j] = (friendMat[i][k] && friendMat[k][j]) || friendMat[i][j];
                 }
             }
         }
    }
    public static void FWPath(boolean[][] friendMat,String[] paths){

    }



}
