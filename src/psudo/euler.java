package psudo;

public class euler{


    array euler_path (G=(v,e)){ //psudo
        stack work, done;
        work.add(v1);
        while(!work.isempty()){
            v = work.peek();
            if (g(v).degree()==0){
                work.pop();
                done.add(v);
            }else {
                u = g(v)[0]; // take first neighbor
                work.add(u);
                g.delete(u,v);
            }
        }
        return done.toArray();
    }



    //psudo
    (int,int,int) best (array){
        start =0;
        best = 0;
        sum = 0;
        end = 0;
        temp_start =0;
        for (i in array) {
            sum+=array[i];
            if (sum<0){
                sum =0;
                start = i+1;
            }
            if(best<sum){
                best = sum;
                start = temp_start;
                end = i;
            }
        }
        return (best,start,end);
    }

   cycle_best(array){
        array_r = -array;

        if(best(array)[0] <array.sum()-(-best(array_r)[0])){
            best =array.sum()-(-best(array_r)[1]);
            start = best(array_r)[0];
            return (start,best);
        }
       return best(array)  ;
    }

    public static void main(String[] args){
        array_a;
        array_b;
        array ;
        for i in array_a{
            array[i] = array_a[i]-array_b[i];
        }
        cycle_best(array)
    }


}
