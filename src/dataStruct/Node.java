package dataStruct;

public class Node<T>{
    Node<T> next;
    Node<T> prev;
    T data;
    int sign;

    public Node(Node<T> next, Node<T> prev, T data){
        this.next = next;
        this.prev = prev;
        this.data = data;
        sign = 0;
    }

    public int getSign(){
        return sign;
    }

    public void setSign(int sign){
        this.sign = sign;
    }

    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public T getData(){
        return data;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public void setPrev(Node<T> prev){
        this.prev = prev;
    }

    public void setData(T data){
        this.data = data;
    }

    @Override
    public String toString(){
        return "->" + data.toString()+":"+sign;
    }
}
