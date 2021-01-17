package CycleDetection;

import dataStruct.Node;

import java.util.Random;

public class makeRandomCycle{
    private Random random;
    private Node<Integer> root;
    private int pathSize;
    private int circleSize;

    public makeRandomCycle(long seed, int pathSize, int circleSize){
        root = new Node<Integer>(null,null,null);
        random = new Random(seed);
        this.pathSize = pathSize;
        this.circleSize = circleSize;
        Node<Integer> lastNode = root;
        for (int j = 1; j < pathSize; j++) {
            Node<Integer> node = new Node<Integer>(null,lastNode,null);
            lastNode.setNext(node);
            lastNode = node;
        }
        Node<Integer>loop = lastNode;
        Node<Integer>lastLoop = null;
        for (int j = 1; j < circleSize; j++) {
            Node<Integer> node = new Node<Integer>(null,lastNode,null);
            lastNode.setNext(node);
            lastNode = node;
            lastLoop =lastNode;

            }
        if (circleSize>0){
            lastNode.setNext(loop);
            loop.setPrev(lastNode);
        }

    }

    public void setRandomDataInt(int bound){
        Node<Integer> pointer =root;
        for (int j = 0; j < pathSize; j++) {
            pointer.setData(random.nextInt(bound));
            pointer = pointer.getNext();
        }
        for (int j = 1; j < circleSize; j++) {
            pointer.setData(random.nextInt(bound));
            pointer = pointer.getNext();
        }
    }
    public void setRandomSign(int bound){
        Node<Integer> pointer =root;
        for (int j = 0; j < pathSize; j++) {
            pointer.setSign(random.nextInt(bound));
            pointer = pointer.getNext();
        }
        for (int j = 1; j < circleSize; j++) {
            pointer.setSign(random.nextInt(bound));
            pointer = pointer.getNext();
        }
    }

    public Node<Integer> getRoot(){
        return root;
    }

    @Override
    public String toString(){
        String s ="";
        Node<Integer> pointer =root;
        for (int j = 0; j < pathSize; j++) {
            s+=pointer.toString();
            pointer = pointer.getNext();
        }
        s+=" loop:";
        for (int j = 0; j < circleSize; j++) {
            s+=pointer.toString();
            pointer = pointer.getNext();
        }
        return "pathSize=" + pathSize +
                ", circleSize=" + circleSize +
                ", nodes: "+s;
    }
}