package algo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Fire{

    /**need tests
     * O(|V|)
     * @param arr
     * @return radios
     */
    public static int fire(ArrayList<Integer>[] arr){
        int n = arr.length;
        int radios = 0;
        int[] degree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            degree[i] = arr[i].size();
            if (degree[i] == 1){
                queue.add(i);
            }
        }
        while (n>2){
            Queue<Integer> queue2 = new LinkedList<>();
            for (int j = 0; j < queue.size(); j++) {
                int leaf = queue.poll();
                degree[leaf] = 0;
                n--;
                for (int i = 0; i < arr[leaf].size(); i++) {
                    int tmp = arr[leaf].get(i);
                    if (degree[tmp] > 0) {
                        degree[tmp]--;
                        if (degree[tmp] == 1) {
                            queue2.add(tmp);
                        }
                    }
                }
            }
            queue = queue2;
            radios++;
        }
        int diameter;
        if (queue.size()==1){
            diameter = radios*2;
        }else {
            radios++;
            diameter = radios*2-1;
        }
        return radios;
    }
    
}
