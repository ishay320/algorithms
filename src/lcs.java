
public class lcs{
    int[][] matrix;
    int array_1;
    int array_2;

    /**
     * @param a
     * @param b
     * @return lcs in greedy algo - (O)n*m
     */
    public String greedy(String a, String b){
        String out = "";
        int indexB = 0;
        int i = 0;
        while (i < a.length() && indexB < b.length()){//(O)n*m
            int index = b.indexOf(a.charAt(i),indexB);
            if (index!=-1){
                out+=a.charAt(i);
                indexB=index+1;
            }
            i++;
        }
        return out;
    }

    /**
     * @param a
     * @param b
     * @return lcs in greedy+ algo - (O)n+m +n
     */
    public String greedyPlus(String a, String b){
        int algo[] = new int[26]; //as 26 chars in the abc

        for (int i = 0; i < a.length(); i++) { //(O)n
            int pos = a.charAt(i)-'a';
            algo[pos]++;
        }

        String out = "";
        int indexB = 0;
        int i = 0;
        while (i < a.length() && indexB < b.length()){ //(O)n+m
            int pos = b.charAt(i)-'a';
            if(algo[pos]>0){
                int index = a.indexOf(b.charAt(i),indexB);
                if (index!=-1){
                    out+=b.charAt(i);
                    indexB=index+1;
                    algo[pos]--;
                }else
                    algo[pos]=0;
            }
            i++;
        }
        return out;
    }
   /*
    public String fullSearch(String a, String b){

    }
    public String dynamic(String a, String b){
        matrix = new int[array_1.length][array_2.length];
    }*/

}
