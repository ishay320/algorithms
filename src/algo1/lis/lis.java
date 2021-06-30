package algo1.lis;

public class lis{
    public static int lengthLis(int a[]){ //O(nlogn)
        int n = a.length;
        int[] temp = new int[n];
        temp[0] = a[0];
        int lis = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(temp, lis, a[i]);
            temp[index] = a[i];
            if (index > lis) {
                lis++;
            }
        }
        return lis + 1;
    }

    public static int binarySearch(int a[], int end, int num){
        int left = 0;
        int right = end;
        int middle = 0;
        if (num < a[0]) {
            return 0;
        }
        if (num > a[end]) {
            return end + 1;
        }
        while (left < right - 1) {
            middle = (right + left) / 2;
            if (a[middle] < num) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return right;
    }

    public static int[] matrixLis(int[] a){ //O(n2 + nlogn)
        int size = a.length;
        int[][] mat = new int[size][size];
        mat[0][0] = a[0];
        int currentLength = 0;
        for (int i = 1; i < size; i++) {
            int index = binarySearch(mat, currentLength, a[i]);
            for (int j = 0; j < index; j++) {
                mat[index][j] = mat[index - 1][j];
            }
            mat[index][index] = a[i];
            if (index > currentLength)
                currentLength++;
        }
        int[] lis = new int[currentLength + 1];
        for (int j = 0; j <= currentLength; j++)
            lis[j] = mat[currentLength][j];
        return lis;
    }

    private static int binarySearch(int a[][], int end, int key){
        int left = 0;
        int right = end;
        int middle = 0;
        if (key < a[0][0])
            return 0;
        if (key > a[end][end])
            return end + 1;
        while (left < right - 1) {
            middle = (left + right) / 2;
            if (a[middle][middle] < key)
                left = middle;
            else
                right = middle;
        }
        return right;
    }


}


