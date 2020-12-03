public class Main {

    public static void main(String[] args) {
        lcs l = new lcs();
        String a="abcde";
        String b = "acbde";
        System.out.println(l.greedy(a,b));
        System.out.println(l.greedyPlus(b,a));

    }
}
