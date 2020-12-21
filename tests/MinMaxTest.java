
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.Random;


import static org.junit.jupiter.api.Assertions.assertEquals;

class MinMaxTest{
    int[] unsortedArr = new int[3];
    Random random = new Random(1);
    int sizeOfArr = 10;
    int maxNumberInArr = 20;

    @BeforeEach
    public void setUp(){
        unsortedArr = new int[sizeOfArr];
        for (int i = 0; i < sizeOfArr; i++) {
            unsortedArr[i] = random.nextInt(maxNumberInArr);
        }
    }

    @Test
    void indexOfMin(){
        int a = unsortedArr[MinMax.IndexOfMin(unsortedArr)];
        Arrays.sort(unsortedArr);
        assertEquals(unsortedArr[0],a);
    }

    @Test
    void indexOfMax(){
        int a = unsortedArr[MinMax.IndexOfMax(unsortedArr)];
        Arrays.sort(unsortedArr);
        assertEquals(unsortedArr[unsortedArr.length-1],a);
    }

    @Test
    void indexMinMax(){
        int a = unsortedArr[MinMax.IndexMinMax(unsortedArr)[0]];
        int b = unsortedArr[MinMax.IndexMinMax(unsortedArr)[1]];
        Arrays.sort(unsortedArr);
        assertEquals(unsortedArr[0],a);
        assertEquals(unsortedArr[unsortedArr.length-1],b);
    }
}