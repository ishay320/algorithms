package lcs;

public class lcs{
    public static int dynamicLcsLen(String a,String b){
        int matrix[][] = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < a.length()+1; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < b.length()+1; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 1; i < a.length()+1; i++) {
            for (int j = 1; j < b.length()+1; j++) {
                if (a.charAt(i-1)==b.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }
                else {
                    matrix[i][j] = Math.max(matrix[i][j-1],matrix[i-1][j]);
                }
            }
        }
        return matrix[a.length()][b.length()];
    }

    public static String dynamicLcsString(String a,String b){
        int matrix[][] = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < a.length()+1; i++) { // O(n)
            matrix[i][0] = 0;
        }
        for (int i = 0; i < b.length()+1; i++) { // O(m)
            matrix[0][i] = 0;
        }
        for (int i = 1; i < a.length()+1; i++) { // O(m*n)
            for (int j = 1; j < b.length()+1; j++) {
                if (a.charAt(i-1)==b.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }
                else {
                    matrix[i][j] = Math.max(matrix[i][j-1],matrix[i-1][j]);
                }
            }
        }

        int count = matrix[a.length()][b.length()];
        int i = a.length();
        int j = b.length();
        String lcs = "";
        while (count>0){ //O(n+m)
            if (a.charAt(i-1)==b.charAt(j-1)) {
                lcs = a.charAt(i-1) + lcs;
                i--;
                j--;
                count--;
            }else {
                if (matrix[i][j]==matrix[i][j-1]){
                    j--;
                }else {
                    i--;
                }
            }
        }
        return lcs;
    }
}
