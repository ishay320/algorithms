public class StringEqual {

    public static int equalGreedy1(String a, String b){
        int size = 0;
        int now = 0;
        for (int i = 0; i < a.length(); i++) {
            int last = now;
            now = b.indexOf(a.charAt(i),now);
            if (now==-1)now=last;
            else size++;
        }


        return size;
    }



}
