package algo1.eggDrop;

public class main{
    public static void main(String[] args){
        System.out.println(eggDrop.dropSim(3,15));
        int matrix[][]=eggDrop.worstCaseMatrixRecursive(5,20);
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.print(i+" - ");
            for (int j = 0; j < 20; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();
        matrix=eggDrop.worstCaseMatrixOptimal(5,20);
        for (int i = 0; i < 6; i++) {
            System.out.println();
            System.out.print(i+" - ");
            for (int j = 0; j < 21; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
}
