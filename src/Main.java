public class Main {

    public static void main(String[] args) {
        lcs l = new lcs();
        String a="abcde";
        String b = "acbde";
        System.out.println(l.greedy(a,b));
        System.out.println(l.greedyPlus(b,a));
        int[] arr ={1,4,2,6,4,7,5,8,4,9,0,12,13};

        System.out.println(MinMax.IndexMinMax(arr)[0]+"   "+MinMax.IndexMinMax(arr)[1]);
    }
}
