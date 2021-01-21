package eggDrop;

public class eggDrop{


    public static int dropSim(int totalEggs,int totalFloors){
        if (totalEggs == 0){
            return 0;
        }
        if (totalFloors==1||totalFloors==0){
            return totalFloors;
        }
        if (totalEggs==1){
            return totalFloors;
        }
        int min = Integer.MAX_VALUE;
        int i, res;
        for (i = 1; i <= totalFloors; i++) {
            res = Math.max(dropSim(totalEggs - 1, i - 1),dropSim(totalEggs, totalFloors - i));
            if (res < min)
                min = res;
        }
        return min + 1;
    }
    public static int[][] worstCaseMatrixRecursive(int totalEggs, int totalFloors){
        int[][] matrix = new int[totalEggs][totalFloors];
        for (int i = 0; i < totalEggs; i++) {
            for (int j = 0; j < totalFloors; j++) {
                matrix[i][j] = dropSim(i,j);
            }
        }
        return matrix;
    }

    public static int[][] worstCaseMatrixOptimal(int totalEggs, int totalFloors)
    {
        int[][] matrix = new int[totalEggs + 1][totalFloors + 1];
        int res;
        int i, j, x;
        for (i = 1; i <= totalEggs; i++) { //initialization of the matrix
            matrix[i][1] = 1;
            matrix[i][0] = 0;
        }
        for (j = 1; j <= totalFloors; j++) {
            matrix[1][j] = j;
        }

        for (i = 2; i <= totalEggs; i++) { //O(n*m^2)
            for (j = 2; j <= totalFloors; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(matrix[i - 1][x - 1], matrix[i][j - x]);
                    if (res < matrix[i][j])
                        matrix[i][j] = res;
                }
            }
        }
        return matrix;
    }
}
