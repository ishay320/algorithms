

public class MinMax {

    /**
     * @param array
     * @return the index of min number in the array - (O)n-1
     */
    public int IndexOfMin(int[] array){
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
    public int IndexOfMax(int[] array){
        int now = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[now]){
                now = i;
            }
        }
        return now;
    }


}
