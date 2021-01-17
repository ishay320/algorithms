package CycleDetection;

import dataStruct.Node;

public class cycleAlgo{
    Node<Integer> root;

    public cycleAlgo(Node<Integer> root){
        this.root = root;
    }

    public int parkingProblem(){ // work only on full loop
        boolean flag = true;
        int oldSign = 0;
        int newSign = 1;
        Node<Integer> currentNode = root.getNext();
        int count = 1;
        int steps = 0;
        root.setSign(oldSign);
        while (flag) {
            if(currentNode.getSign() != oldSign){ // check when step to oldSign
                currentNode = currentNode.getNext();
                count++;
            } else {
                currentNode.setSign(newSign); // set newSign
                steps = count;
                while (steps >= 0) { // loop for steps back
                    currentNode = currentNode.getPrev();
                    steps--; // decrease the step
                }
                if (currentNode.getSign() == newSign) {// got back to newSign
                    flag = false;
                } else {
                    count = 1;
                    root.setSign(oldSign);
                    currentNode = root.getNext();
                }
            }
        }
        return count;
    }
//       public Node<Integer> twoFingers(){
//
//       }


}
