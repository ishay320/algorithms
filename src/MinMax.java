

public class MinMax {

    /**
     * @param array
     * @return the index of min number in the array - (O)n-1
     */
    public static int IndexOfMin(int[] array){
        int now = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[now]){
                now = i;
            }
        }
        return now;
    }

    /**
     * @param array
     * @return the index of max number in the array - (O)n-1
     */
    public static int IndexOfMax(int[] array){
        int now = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[now]){
                now = i;
            }
        }
        return now;
    }

    /**
     * min + max algo - (O)3*n/2 -2
     * or (O)1.5*n
     * @param array
     * @return array with the min position at [0] and max at [1]
     */
    public static int[] IndexMinMax(int[] array){
        int minMax[] = new int[2];
        int min , max;
        if (array[0]<array[1]){ //setup
            min = array[0];
            max = array[1];
        }else {
            min = array[1];
            max = array[0];
        }
        for (int i = 2; i < array.length-1; i+=2) {
            if (array[i]<array[i+1]){
                if (max<array[i+1]){
                    max = array[i+1];
                }
                if (min>array[i]){
                    min = array[i];
                }
            }else {
                if (max<array[i]){
                    max = array[i];
                }
                if (min>array[i+1]){
                    min = array[i+1];
                }
            }
        }
        if (array.length%2!=0){ //if the last one in array lost
            if (max<array[array.length-1]){
                max = array[array.length-1];
            }else
            if (min>array[array.length-1]){
                min = array[array.length-1];
            }
        }
        minMax[0]=min;
        minMax[1]=max;
        return minMax;
    }
}
