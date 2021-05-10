package CycleDetection;

import dataStruct.Node;

public class cycleAlgo<T>{
    private Node<T> root;

    /**
     *
     *
     */


    public cycleAlgo(Node<T> root){
        this.root = root;
    }

    public int parkingProblem(){ // work only on full loop
        boolean flag = true;
        int oldSign = 0;
        int newSign = 1;
        Node<T> currentNode = root.getNext();
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
    public boolean twoFingersHaveLoop(){
        Node<T> turtle = root;
        Node<T> hare = root;
        while (true){
            if (turtle.getNext() == null){
                return false;
            }
            if (hare.getNext() == null || hare.getNext().getNext() == null){
                return false;
            }
            turtle = turtle.getNext();
            hare = hare.getNext().getNext();
            if (turtle==hare){
                return true;
            }
        }
    }

    public Node<T> twoFingersMeetingPoint(){
        Node<T> turtle = root;
        Node<T> hare = root;
        while (true){
            if (turtle.getNext() == null){
                return null;
            }
            if (hare.getNext() == null || hare.getNext().getNext() == null){
                return null;
            }
            turtle = turtle.getNext();
            hare = hare.getNext().getNext();
            if (turtle==hare){
                return turtle;
            }
        }
    }

    public Node<T> twoFingersCircleBegin(Node<T> meetup){
        Node<T> turtle = root;
        Node<T> hare = meetup;
        if (meetup == null){
            return null;
        }
        while (turtle!=hare){
            hare = hare.getNext();
            if (turtle==hare.getNext()){
                return turtle;
            }
            turtle = turtle.getNext();

        }
        return turtle;
    }

    public long twoFingerLoopLength(Node<T> meetup){
        if (meetup == null){
            return -1;
        }
        Node<T> turtle = meetup.getNext();
        Node<T> hare = meetup;
        long length = 1;
        while (turtle!=hare){
            turtle = turtle.getNext();
            length++;
        }
    return length;
    }


}
