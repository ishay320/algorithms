package dataStruct;

public class friendMat{
    private final boolean[][] mat;
    private boolean isViable(int x){
        return x<mat.length && x>=0;
    }
    public friendMat(int nodeSize){
        mat = new boolean[nodeSize][nodeSize];
    }
    public void addConnection(int a,int b) throws Exception{
        if (!isViable(a)||!isViable(b))throw new Exception();
        mat[a][b] = true;
        mat[b][a] = true;
    }
    public void removeConnection(int a,int b) throws Exception{
        if (!isViable(a)||!isViable(b))throw new Exception();
        mat[a][b] = false;
        mat[b][a] = false;
    }
    public boolean[][] getMat(){
        return mat;
    }
    public boolean getConnection(int a,int b) throws Exception{
        if (!isViable(a)||!isViable(b))throw new Exception();
        return mat[a][b];
    }
}
